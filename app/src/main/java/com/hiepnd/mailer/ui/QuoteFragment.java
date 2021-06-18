package com.hiepnd.mailer.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.hiepnd.mailer.R;
import com.hiepnd.mailer.databinding.QuoteFragmentBinding;
import com.hiepnd.mailer.viewmodel.QuoteViewModel;

public class QuoteFragment extends Fragment {
    private QuoteFragmentBinding mBinding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        Log.println(Log.INFO, "QuoteFragment", "onCreateView");
        // Inflate this data binding layout
        mBinding = DataBindingUtil.inflate(inflater, R.layout.quote_fragment, container, false);

        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.println(Log.INFO, "QuoteFragment", "onViewCreated");

        final QuoteViewModel model = new ViewModelProvider(this).get(QuoteViewModel.class);
        mBinding.setLifecycleOwner(getViewLifecycleOwner());
        mBinding.setQuoteViewModel(model);
        subscribeToModel(model);


        view.findViewById(R.id.button_send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // send quote of the day to recipients

                // display the result

            }
        });
    }

    private void subscribeToModel(final QuoteViewModel model) {
        // Observe quotes
        model.getQuoteResponse().observe(getViewLifecycleOwner(), quoteResponse -> {
            if (quoteResponse != null) {
                Log.println(Log.INFO, "Quote Response", quoteResponse.toString());
            }
        });
    }

    @Override
    public void onDestroyView(){
        mBinding = null;
        super.onDestroyView();
    }
}