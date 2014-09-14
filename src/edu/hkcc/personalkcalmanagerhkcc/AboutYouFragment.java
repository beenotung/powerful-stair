package edu.hkcc.personalkcalmanagerhkcc;

import edu.hkcc.myutils.Utils;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AboutYouFragment {
	private MainActivity mainActivity;

	protected String name;
	protected float height, weight, bmi;
	protected int age;

	public AboutYouFragment(MainActivity mainActivity) {
		this.mainActivity = mainActivity;
	}

	public View.OnClickListener aboutYou_button_calcuateBmi(Context context) {
		final Context myContext = context;
		return new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (allFilled()) {
					Utils.showToast(myContext, R.string.aboutyou_calculating);
					calcBmi();
				} else {
					Utils.showToast(myContext,
							R.string.aboutyou_pleasefillallinfo);
				}
			}
		};
	}

	protected boolean allFilled() {
		// TODO Auto-generated method stub
		boolean allFilled = true;
		String temp;
		temp = mainActivity.aboutyou_edittext_userheight.getText().toString();
		if (allFilled &= (allFilled &= temp.length() > 0))
			height = Float.valueOf(temp);
		temp = mainActivity.aboutyou_edittext_userweight.getText().toString();
		if (allFilled &= (allFilled &= temp.length() > 0))
			weight = Float.valueOf(temp);
		return allFilled;
	}

	protected void calcBmi() {
		bmi=(float) (weight/Math.pow(height, 2));
		mainActivity.aboutyou_edittext_userbmi.setText(String.valueOf(bmi));
	}
}
