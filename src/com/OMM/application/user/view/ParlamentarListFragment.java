package com.OMM.application.user.view;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.ListFragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.OMM.application.user.controller.ParlamentarUserController;
import com.OMM.application.user.model.Parlamentar;

public class ParlamentarListFragment extends ListFragment {

	private OnParlamentarSelectedListener listener;

	ParseTask parseTask;

	static ParlamentarUserController pc = ParlamentarUserController
			.getInstance();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		List<Parlamentar> list = new ArrayList<Parlamentar>();
		MyAdapter adapter = new MyAdapter(getActivity(),
				android.R.layout.simple_list_item_1, list);

		setListAdapter(adapter);
		setRetainInstance(true);

	}

	public void onListParlamentarClick(ListView l, View v, int position, long id) {
		Parlamentar parlamentar = (Parlamentar) getListAdapter().getItem(
				position);
		updateDetail(parlamentar);

	}

	private static class ParseTask extends
			AsyncTask<String, Void, List<Parlamentar>> {

		private ParlamentarListFragment fragment;

		public void setFragment(ParlamentarListFragment fragment) {
			this.fragment = fragment;
		}

		@Override
		protected List<Parlamentar> doInBackground(String... arg0) {
			// TODO Auto-generated method stub
			// Aqui vai aparecer a chamda da controller.
			return null;
		}

		@Override
		protected void onPostExecute(List<Parlamentar> result) {

			fragment.setListContent(result);

		}
	}

	public void updateListContent() {

		if (parseTask == null) {

			parseTask = new ParseTask();
			parseTask.setFragment(this);

		}
	}

	public void setListContent(List<Parlamentar> result) {

		ArrayAdapter listAdapter = (ArrayAdapter) getListAdapter();
		listAdapter.clear();
		listAdapter.addAll(result);
		parseTask.setFragment(null);

	}
	
	public interface OnParlamentarSelectedListener{
		public void OnParlamentarSelected(String nome);
	}
	

	@Override
	public void onAttach(Activity activity){
		super.onAttach(activity);
		if(activity instanceof OnParlamentarSelectedListener){
			listener = (OnParlamentarSelectedListener) activity;
		}
		else{
			throw new ClassCastException(activity.toString()
					+ "must implement MyListFragment.OnParlamentarSelectedListner");
		}
	}

	public void updateDetail(Parlamentar parlamentar){
		
		listener.OnParlamentarSelected(parlamentar.getNome());
	}



}
