package com.hiepnd.mailer.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.textfield.TextInputLayout;
import com.hiepnd.mailer.R;
import com.hiepnd.mailer.databinding.QuoteFragmentBinding;
import com.hiepnd.mailer.service.EmailService;
import com.hiepnd.mailer.viewmodel.QuoteViewModel;

public class QuoteFragment extends Fragment {
    private QuoteFragmentBinding mBinding;
    private TextInputLayout textInputEmails;
    private TextView textViewTitle;
    private TextView textViewBody;
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
        textInputEmails = getView().findViewById(R.id.textInputLayout);
        textViewTitle =  getView().findViewById(R.id.textView_title);
        textViewBody =  getView().findViewById(R.id.textView_body);

        view.findViewById(R.id.button_send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // send quote of the day to emails
                String emailList = textInputEmails.getEditText().getText().toString();
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
                    String title = textViewTitle.getText().toString().trim();
                    String body = textViewBody.getText().toString().trim();

                    EmailService emailService = new EmailService(getContext(), emails, title, body);
                    emailService.execute();
                }

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