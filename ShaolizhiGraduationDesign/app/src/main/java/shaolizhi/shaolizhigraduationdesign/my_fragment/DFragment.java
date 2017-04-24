package shaolizhi.shaolizhigraduationdesign.my_fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import shaolizhi.shaolizhigraduationdesign.R;
import shaolizhi.shaolizhigraduationdesign.my_activity.WelcomeActivity;

/**
 * Created by shaol on 2017/4/7.
 */

public class DFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        View rootView = inflater.inflate(R.layout.d_fragment, viewGroup, false);



        return rootView;
    }
}
