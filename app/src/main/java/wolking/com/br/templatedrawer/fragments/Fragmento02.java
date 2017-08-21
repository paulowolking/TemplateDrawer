package wolking.com.br.templatedrawer.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import wolking.com.br.templatedrawer.R;
import wolking.com.br.templatedrawer.utils.BaseFragment;

public class Fragmento02 extends BaseFragment {
    public static Fragment newInstance(Context context) {
        Fragmento02 f = new Fragmento02();
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_02, null);

        return root;
    }
}
