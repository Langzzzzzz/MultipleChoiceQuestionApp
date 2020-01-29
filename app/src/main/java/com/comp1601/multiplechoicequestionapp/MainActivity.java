package com.comp1601.multiplechoicequestionapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mAButton;
    private Button mBButton;
    private Button mCButton;
    private Button mDButton;
    private Button mEButton;
    private Button mPrevButton;
    private Button mSubmitButton;
    private Button mNextButton;

    TextView mQuestionTextView;
    private int mCurrentQuestionIndex = 0;

    ArrayList<Question> mQuestions = new ArrayList<Question>();
    ArrayList<String> correctAnswer = new ArrayList<String>();
    ArrayList<String> userAnswer = new ArrayList<String>(Collections.nCopies(10, "f"));
    ArrayList<Button> AnswerbuttonList = new ArrayList<Button>();
    ArrayList<Button> ControlbuttonList = new ArrayList<Button>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAButton = findViewById(R.id.a_button);
        mBButton = findViewById(R.id.b_button);
        mCButton = findViewById(R.id.c_button);
        mDButton = findViewById(R.id.d_button);
        mEButton = findViewById(R.id.e_button);
        mPrevButton = findViewById(R.id.prev_button);
        mSubmitButton = findViewById(R.id.submit_button);
        mNextButton = findViewById(R.id.next_button);

        mQuestions.add(new Question(getString(R.string.question1)));
        mQuestions.add(new Question(getString(R.string.question2)));
        mQuestions.add(new Question(getString(R.string.question3)));
        mQuestions.add(new Question(getString(R.string.question4)));
        mQuestions.add(new Question(getString(R.string.question5)));
        mQuestions.add(new Question(getString(R.string.question6)));
        mQuestions.add(new Question(getString(R.string.question7)));
        mQuestions.add(new Question(getString(R.string.question8)));
        mQuestions.add(new Question(getString(R.string.question9)));
        mQuestions.add(new Question(getString(R.string.question10)));

        AnswerbuttonList.add(mAButton);
        AnswerbuttonList.add(mBButton);
        AnswerbuttonList.add(mCButton);
        AnswerbuttonList.add(mDButton);
        AnswerbuttonList.add(mEButton);
        ControlbuttonList.add(mPrevButton);
        ControlbuttonList.add(mSubmitButton);
        ControlbuttonList.add(mNextButton);

        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);
        mQuestionTextView.setText(mQuestions.get(mCurrentQuestionIndex).getQuestion());

        /*
         * only for testing ;
         * */
        for (Question q: mQuestions) System.out.println("Q: " + q.getQuestion()+ " \nA: "+ q.getAnswer()+"\n");
        for (Question x: mQuestions) correctAnswer.add(x.getAnswer());
        for (String j: correctAnswer) System.out.println(j);
        for (String a: userAnswer) System.out.println(a);

        if(mCurrentQuestionIndex == 0) mPrevButton.setEnabled(false);

        mAButton.setOnClickListener(this);
        mBButton.setOnClickListener(this);
        mCButton.setOnClickListener(this);
        mDButton.setOnClickListener(this);
        mEButton.setOnClickListener(this);
        mPrevButton.setOnClickListener(this);
        mSubmitButton.setOnClickListener(this);
        mNextButton.setOnClickListener(this);

    }

    public int getMark(ArrayList<String> correct, ArrayList<String> user){
        int result = 0;
        for (int i = 0; i< correct.size(); i++) {
            if(correct.get(i).equals(user.get(i))){
                result++;
            }
        }
        return result;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case  R.id.a_button: {
                // do something for button a click
                for (Button x: AnswerbuttonList) x.setEnabled(true);
                mAButton.setEnabled(false);
                userAnswer.set(mCurrentQuestionIndex,"a");
                break;
            }

            case R.id.b_button: {
                // do something for button b click
                for (Button x: AnswerbuttonList) x.setEnabled(true);
                mBButton.setEnabled(false);
                userAnswer.set(mCurrentQuestionIndex,"b");
                break;
            }
            case  R.id.c_button: {
                // do something for button c click
                for (Button x: AnswerbuttonList) x.setEnabled(true);
                mCButton.setEnabled(false);
                userAnswer.set(mCurrentQuestionIndex,"c");
                break;
            }

            case R.id.d_button: {
                // do something for button d click
                for (Button x: AnswerbuttonList) x.setEnabled(true);
                mDButton.setEnabled(false);
                userAnswer.set(mCurrentQuestionIndex,"d");
                break;
            }

            case  R.id.e_button: {
                // do something for button e click
                for (Button x: AnswerbuttonList) x.setEnabled(true);
                mEButton.setEnabled(false);
                userAnswer.set(mCurrentQuestionIndex,"e");
                break;
            }

            case R.id.prev_button: {
                // do something for button prev click
                for (Button x: AnswerbuttonList) x.setEnabled(true);
                for (Button x: ControlbuttonList) x.setEnabled(true);
                mCurrentQuestionIndex--;
                if(mCurrentQuestionIndex == 0) mPrevButton.setEnabled(false);
                mQuestionTextView.setText(mQuestions.get(mCurrentQuestionIndex).getQuestion());
                break;
            }

            case  R.id.submit_button: {
                // do something for button submit click
                for (Button y: AnswerbuttonList) y.setEnabled(true);
                for (Button x: ControlbuttonList) x.setEnabled(true);
                int mark = getMark(correctAnswer,userAnswer);
                String markAsString = Integer.toString(mark);

                String result = markAsString+"/10";
                Toast.makeText(MainActivity.this,
                        result,
                        Toast.LENGTH_SHORT).show();
                break;
            }

            case R.id.next_button: {
                // do something for button next click
                for (Button y: AnswerbuttonList) y.setEnabled(true);
                for (Button x: ControlbuttonList) x.setEnabled(true);
                mCurrentQuestionIndex++;
                if((mCurrentQuestionIndex+1) == userAnswer.size()) mNextButton.setEnabled(false);
                mQuestionTextView.setText(mQuestions.get(mCurrentQuestionIndex).getQuestion());
                break;
            }
            //.... etc
        }
    }
}
