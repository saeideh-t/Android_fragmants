package com.example.fragmentsproject;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;




public class DialogFragmentClass extends DialogFragment implements View.OnClickListener {

    public static DialogFragmentClass newInstance(int helpResId)	{
        DialogFragmentClass hdf = new DialogFragmentClass();
        Bundle bundle = new Bundle();
        bundle.putInt("help_resource", helpResId);
        hdf.setArguments(bundle);
        return hdf;
    }

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        this.setCancelable(true);
        int style = DialogFragment.STYLE_NORMAL, theme = 0;
        setStyle(style,theme);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle icicle)  {
        View v = inflater.inflate(R.layout.help_dialog, container, false);

        TextView tv = (TextView)v.findViewById(R.id.dialgo_text);
        tv.setText(getActivity().getResources().getText(getArguments().getInt("help_resource")));

        Button closeBtn = (Button)v.findViewById(R.id.cancelbut);
        closeBtn.setOnClickListener(this);
        return v;
    }

    public void onClick(View v) {

        dismiss();
    }
}

