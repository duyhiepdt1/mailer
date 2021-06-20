package com.hiepnd.mailer.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.hiepnd.mailer.R;
import com.hiepnd.mailer.databinding.QuoteFragmentBinding;
import com.hiepnd.mailer.model.QuoteResponse;
import com.hiepnd.mailer.service.EmailService;
import com.hiepnd.mailer.viewmodel.QuoteViewModel;

public class QuoteFragment extends Fragment {
    private QuoteFragmentBinding mBinding;
    private String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    public View onCreateView(@NonNull
            LayoutInflater  inflater, ViewGroup container,
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
                // send quote of the day to emails
                String emailList = "";
                EditText editTextEmail = mBinding.textInputLayout.getEditText();
                if(editTextEmail != null) {
                    emailList = editTextEmail.getText().toString().trim();
                }
                String[] emails = emailList.split(",");
                if (emailList.isEmpty()) {
                    Toast.makeText(getContext(), "Enter email address", Toast.LENGTH_SHORT).show();
                } else {
                    for (int i=0; i < emails.length; i++) {
                        String email = emails[i];

                        if(!email.trim().matches(emailPattern)){
                            Log.println(Log.INFO, "QuoteFragment", "Invalid email: " + email);
                            Toast.makeText(getContext(), "Invalid email address", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }

                    String subject = "";
                    String message = "";
                    QuoteResponse quoteResponse = model.getQuoteResponse().getValue();
                    if (quoteResponse != null) {
                        subject = quoteResponse.getQuoteContents().getQuotes().get(0).getTitle();
                        message = quoteResponse.getQuoteContents().getQuotes().get(0).getQuote();
                    }

//                    String subject = mBinding.textViewTitle.getText().toString().trim();
//                    String message = mBinding.textViewBody.getText().toString().trim();
                    if ( !"".equals(subject) && !"".equals(message)) {
                        EmailService emailService = new EmailService(getContext(), emails, subject, message);
                        emailService.execute();
                    }
                }

            }
        });
    }

    private void subscribeToModel(final QuoteViewModel model) {
        // Observe quotes
        model.getQuoteResponse().observe(getViewLifecycleOwner(), quoteResponse -> {
            if (quoteResponse != null) {
                Log.println(Log.INFO, "QuoteFragment", quoteResponse.toString());
            }
        });
    }

    @Override
    public void onDestroyView(){
        mBinding = null;
        super.onDestroyView();
    }
}