package zk.maven.controller;

import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.DelegatingVariableResolver;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Messagebox;

import zk.maven.dao.PersonDAO;
import zk.maven.entity.Person;

@VariableResolver(DelegatingVariableResolver.class)
public class PersonController extends SelectorComposer<Component>{
	
	
	private static final long serialVersionUID = 1L;
	
	@WireVariable("personDAO")
	private PersonDAO dao;
	@Wire
	private Listbox listPerson;
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);		
		loadData();
	}

	public void loadData() {
		try {
			List<Person> result = dao.getAll();
			listPerson.setModel(new ListModelList<Person>(result));
		} catch (Exception ex) {
			ex.printStackTrace();
			Messagebox.show(ex.getMessage(), "Error", Messagebox.OK,
					Messagebox.ERROR);
		}
	}

}
