package extended.cs.sdsu.edu.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import extended.cs.sdsu.edu.domain.Professor;
import extended.cs.sdsu.edu.service.ProfessorService;

public class ProfessorListActivity extends ListActivity {

	private List<Professor> professorList = new ArrayList<Professor>();
	private ProfessorListAdapter professorListAdapter;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		ProfessorService professorService = new ProfessorService();
		refreshProfessorList(professorService);
		// professorService.getProfessorList(this);
	}

	@Override
	protected void onListItemClick(ListView listView, View view, int position,
			long id) {
		super.onListItemClick(listView, view, position, id);
		// Professor professor = (Professor)
		// listView.getItemAtPosition(position);
		// int selectedProfessorId = professor.getId();
		// System.out.println(selectedProfessorId);
		System.out.println("Hi");
	}

	private void refreshProfessorList(ProfessorService professorService) {
		try {
			professorList = professorService.getProfessorList(this);

			professorListAdapter = new ProfessorListAdapter(professorList, this);
			setListAdapter(professorListAdapter);
			professorListAdapter.refreshList(professorList);
			professorListAdapter.notifyDataSetChanged();
		} catch (Exception e) {
			Log.e("RateMyProfessor", e.getMessage(), e);
		}
	}
}