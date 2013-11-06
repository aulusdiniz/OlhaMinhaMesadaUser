package com.OMM.application.user.view;

import java.util.List;

import com.OMM.application.user.R;
import com.OMM.application.user.model.Parlamentar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MyAdapter extends ArrayAdapter<Parlamentar> {
	private Context context;
	private List<Parlamentar> parlamentares;

	public MyAdapter(Context context, int textViewResourceId,
			List<Parlamentar> parlamentares) {
		super(context, textViewResourceId, parlamentares);

		this.context = context;
		this.parlamentares = parlamentares;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.fragment_parlamentar, null);
		TextView textView = (TextView) view.findViewById(R.id.textView1);
		textView.setText(parlamentares.get(position).getNome());
		return view;
	}
}
