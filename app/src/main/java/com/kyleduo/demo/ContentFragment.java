package com.kyleduo.demo;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ContentFragment extends Fragment {

	private TextView mVersionTextView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View content = inflater.inflate(R.layout.fragment_content, container, false);
		mVersionTextView = (TextView) content.findViewById(R.id.content_version);
		mVersionTextView.setText(String.format(getString(R.string.content_version), Build.VERSION.RELEASE, Build.VERSION.SDK_INT));
		return content;
	}

}
