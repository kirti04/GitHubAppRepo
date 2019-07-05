package com.example.myrepositories;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.RootMatchers;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;


import com.example.myrepositories.View.MainActivity;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.regex.Matcher;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);


    @Test
    public void TestCase_isRecyclerDisplayed() {
        onView(withId(R.id.repoList)).check(ViewAssertions.matches(isDisplayed()));
    }

    @Test
    public void Testcase_forRecyclerViewScroll() {

        RecyclerView recyclerView  = mActivityRule.getActivity().findViewById(R.id.repoList);
        /*int itemcount=  recyclerView.getAdapter().getItemCount();
        System.out.println("item" + itemcount);*/
        Espresso.registerIdlingResources(mActivityRule.getActivity().countingIdlingResource);
        Espresso.onView(ViewMatchers.withId(R.id.repoList))
                .inRoot(RootMatchers.withDecorView(Matchers.is(mActivityRule.getActivity().getWindow().getDecorView())))
                .perform(RecyclerViewActions.scrollToPosition(30-1));

    }
    @Test
    public void Testcase_forRecyclerOnItemClick() {
        Espresso.registerIdlingResources(mActivityRule.getActivity().countingIdlingResource);
        Espresso.onView(ViewMatchers.withId(R.id.repoList))
                .inRoot(RootMatchers.withDecorView(Matchers.is(mActivityRule.getActivity().getWindow().getDecorView())))
                .perform(RecyclerViewActions.actionOnItemAtPosition(3,click()));
        }



}

