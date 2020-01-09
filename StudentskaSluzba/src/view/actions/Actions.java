/**
 * 
 */
package view.actions;

/**
 * Klasa koja cuva instance akcija koje dele traka sa alatima i traka sa
 * menijima.
 * 
 * @author Milana Todorovic ra3-2017
 *
 */
public class Actions {

	private NewAction newAction;
	private EditAction editAction;
	private DeleteAction deleteAction;

	public Actions() {
		this.newAction = new NewAction();
		this.editAction = new EditAction();
		this.deleteAction = new DeleteAction();
	}

	/**
	 * @return the newAction
	 */
	public NewAction getNewAction() {
		return newAction;
	}

	/**
	 * @return the editAction
	 */
	public EditAction getEditAction() {
		return editAction;
	}

	/**
	 * @return the deleteAction
	 */
	public DeleteAction getDeleteAction() {
		return deleteAction;
	}

}
