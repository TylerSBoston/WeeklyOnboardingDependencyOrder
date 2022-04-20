import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class DependencyOrganizer {

	// used for ordering projects, might not be the easiest way but should cover most if not all edge cases
	private class ProjectNode{
		public String project;
		public HashMap<String,ProjectNode> pastNodes  = new HashMap<String,ProjectNode>();
		
		ProjectNode(String project){
			this.project = project;
		}
		
	}
	//feels safer to use strings as keys than with a hashset
	private HashMap<String,ProjectNode> clearedNodes = new HashMap<String,ProjectNode>(); ; // nodes in which all previous nodes are included
	private HashMap<String,ProjectNode> pendingNodes = new HashMap<String,ProjectNode>(); ; // nodes which hasn't had a previous nodes cleared
	private HashMap<String,ProjectNode> floatingNodes = new HashMap<String,ProjectNode>(); ; // nodes with no future or past nodes;
	private HashMap<String,ProjectNode> allNodes = new HashMap<String,ProjectNode>(); // for checking if a node exists
	private HashMap<String,ProjectNode> unclearedNodes = new HashMap<String,ProjectNode>(); ; // nodes not yet ordered
 	private LinkedList<ProjectNode> finalOrder = new LinkedList<ProjectNode>(); //holds final order to be compiled into a single string 
 	
 	
 	// here for scope, used by lambda forEach loops
	private boolean pass; // checks if previous nodes are 'cleared'
	private boolean progress; // checks if the node order got current in the previous loop
	
	
	// can be overloaded to take hashsets/maps as well only including lists for now.
	// output can be converted into a list of projects but string used for the prompt
	// again probably not simplist way, but should always work
	public String generateBootOrder(List<String> projects, String[][] bootOrder) throws InvalidOrderException, InvalidProjectException, DuplicateProjectException
	{
		finalOrder.clear();
		clearAllNodes();
		buildMap(projects,bootOrder);
		return calculateOrder();
	}
	
	// builds node map to be used to build a valid order
	private void buildMap(List<String> projects, String[][] bootOrder) throws InvalidProjectException, DuplicateProjectException
	{
		for(String s : projects)
		{
			ProjectNode project = new ProjectNode(s);
			if(!allNodes.containsKey(s))
			{
				floatingNodes.put(s, project);
				allNodes.put(s, project);
				unclearedNodes.put(s,project);
			}
			else
			{
				throw new DuplicateProjectException();
			}
		}
		
		for(String[] dependency : bootOrder)
		{
			if(allNodes.containsKey(dependency[0]) && allNodes.containsKey(dependency[1]))
			{

				
				//dependent string/project
				if(floatingNodes.containsKey(dependency[1]))
				{
					floatingNodes.get(dependency[1]).pastNodes.put(dependency[0],new ProjectNode(dependency[0]));
					pendingNodes.put(dependency[1], floatingNodes.get(dependency[1]));
					floatingNodes.remove(dependency[1]);
					
				}
				else if(pendingNodes.containsKey(dependency[1]))
				{
					pendingNodes.get(dependency[1]).pastNodes.put(dependency[0],new ProjectNode(dependency[0]));
				}	
			}
			else
			{
				throw new InvalidProjectException();
			}			
		}
	}
	
	private void clearAllNodes()
	{

		pendingNodes.clear();
		floatingNodes.clear();
		allNodes.clear();
		clearedNodes.clear();
		unclearedNodes.clear();
		
	}
	
	
	private String printOrder()
	{
		String returnOrder = "";
		
		for(ProjectNode p : finalOrder)
		{
			if (returnOrder != "")
			{
				returnOrder = returnOrder + ", " + p.project;
			}
			else
			{
				returnOrder = returnOrder + p.project;
			}
			
		}
		return returnOrder;
	}
	
	private String calculateOrder() throws InvalidOrderException 
	{
		floatingNodes.forEach((key,value) ->{
			finalOrder.add(value);
			clearedNodes.put(key, value);
			unclearedNodes.remove(key);
		});	
		// checks if program failed to find a valid next project to place
		progress = true;
		while(progress)
		{
			progress = false;
			// logic to find available projects to add to the order
			// may be slow with excessively large load orders with many dependencies
			pendingNodes.forEach((key,value) ->{
				pass = true;
				value.pastNodes.forEach((innerKey,innerValue) ->{
					if(unclearedNodes.containsKey(innerKey))
					{
						pass = false;
					}
				});
				if(pass && unclearedNodes.containsKey(key))
				{
					progress = true;
					finalOrder.add(value);
					clearedNodes.put(key,value);
					unclearedNodes.remove(key);					
				}
			});	

			if(unclearedNodes.size() == 0)
			{
				clearAllNodes();
				return printOrder();
			}
			else if(progress == false)
			{
				throw new InvalidOrderException();
			}
		}		
		//unreachable
		return null;
	}
}
