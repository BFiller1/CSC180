package labs.five;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileBasedDatasource{

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String input;
	Auction auc;
	String name;
	AuctionService as;
	//handles all crud statements
	AuctionCreateState acs = new AuctionCreateState(name, as);
	String userInput = null;

	//if Owner does not equal null name cannot be edited
	//description anytime
	//end date if owner does not equal null cannot edit
	//price if owner does not equal null cannot edit
	public void editing(Auction auc){
		System.out.println("It appears that you have created one or more items in the search results, would you like to edit/delete an item (y/n)");
		try {
			userInput = br.readLine();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(userInput.equalsIgnoreCase("y")){
			//print out the items they own
			boolean loop = false;
			do{
			System.out.println("Type in the id of the item to edit/delete.");
			long id = 0;
			try {
				input = br.readLine();
				id = Integer.parseInt(input);
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("Do you want to edit the 1)name, 2)description, 3)end date, 4)price or 5)delete.");
			System.out.println("Type in the corresponding number to select what you would like to edit");
			System.out.println("1) name             (current name: '" + auc.getName() + "')");
			System.out.println("2) description      (current description: '" + auc.getDescription() + "')");
			System.out.println("3) end date         (current end date '" + auc.getEndsBy() + "')");
			System.out.println("4) price            (current price '" + auc.getCurrentBid() + "')");
			System.out.println("5) delete           (current item selected for deletion '" + auc.getName() + "')");
			try {
				input = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(input.equalsIgnoreCase("1")){
				if(auc.getCreator().equals(name) && auc.getOwner() == null){
					System.out.println("The current naem is \"" + auc.getName() + "\" type in the new name.");

					System.out.print("Type in the new name: ");
					as.update(id, auc);
					try {
						input = br.readLine();
						auc.setName(input);
					} catch (IOException e) {
						e.printStackTrace();
					}
					System.out.println("The new name is \"" + auc.getName() + "\".");
				}
				else{
					System.out.println("You are not the owner of the selected item or a bid was already placed on the item.");
				}
			}
			else if(input.equalsIgnoreCase("2")){
					System.out.println("The current description is \"" + auc.getDescription() + "\" type in the new description.");
					System.out.println("Type in the new description");
					as.update(id, auc);
					try {
						input = br.readLine();
						auc.setDescription(input);
					} catch (IOException e) {
						e.printStackTrace();
					}
			}
			else if(input.equalsIgnoreCase("3")){
				//edit the end date
			}
			else if(input.equalsIgnoreCase("4")){
				as.update(id, auc);
				try {
					input = br.readLine();
					int price = Integer.parseInt(input);
					auc.setCurrentBid(price);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			else if(input.equalsIgnoreCase("5")){
				//item will be deleted
				System.out.println("The item is now deleted.");
				as.delete(id);
			}
			else{
				System.out.println("Would you like to edit something else. (y/n)");
				try {
					userInput = br.readLine();
					if(userInput.equalsIgnoreCase("y")){
						loop = true;
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			}
			while(loop == true);

			//then ask them to select the id that they want to edit
			//then print out question to ask if they want to edit the name, description, end date, price
			//if there was a bid placed print
			//I'm sorry the section you want to edit cannot be edited as there has been a bid placed, the sections that aren't affected by this is the description section of the auction item.
		
//		else{
//			System.out.println("no item edited");
//		}
	}
}
	}


