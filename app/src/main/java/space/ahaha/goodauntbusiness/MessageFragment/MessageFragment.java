package space.ahaha.goodauntbusiness.MessageFragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import space.ahaha.goodauntbusiness.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_message, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public static MessageFragment newInstance(String content) {
        Bundle args = new Bundle();
        args.putString("ARGS", content);
        MessageFragment fragment = new MessageFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
