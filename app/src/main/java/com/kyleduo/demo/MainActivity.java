package com.kyleduo.demo;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.readystatesoftware.systembartint.SystemBarTintManager;


public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
		setSupportActionBar(toolbar);

		getSupportFragmentManager().beginTransaction().add(R.id.main_content_container, new ContentFragment()).commit();

		if (Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT) {
			SystemBarTintManager tintManager = new SystemBarTintManager(this);
			tintManager.setStatusBarTintEnabled(true);
			tintManager.setStatusBarTintResource(R.color.status_bar_color);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Intent intent = new Intent(Intent.ACTION_VIEW);
		int id = item.getItemId();
		switch (id) {
			case R.id.action_github:
				intent.setData(Uri.parse("https://github.com/kyleduo/MDNavigationDrawer"));
				startActivity(intent);
				return true;
			case R.id.action_blog:
				intent.setData(Uri.parse("http://www.kyleduo.com/?p=437"));
				startActivity(intent);
				return true;
			default:
				break;
		}
		return super.onOptionsItemSelected(item);
	}
}
