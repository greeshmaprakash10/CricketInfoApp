package com.app.cricket;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CommentaryFragment extends Fragment
{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_commentary, container, false);
        addShareVideoFragment();

        return rootView;
    }

    private void addShareVideoFragment() {
        ShareVideoFragment shareVideoFragment = new ShareVideoFragment();
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.facebook_video_share_button, shareVideoFragment);
        fragmentTransaction.commit();
    }

}
