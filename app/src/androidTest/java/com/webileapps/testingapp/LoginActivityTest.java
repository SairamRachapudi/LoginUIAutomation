package com.webileapps.testingapp;

import android.support.test.espresso.ViewAction;
import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.core.deps.guava.collect.ArrayListMultimap;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.TextView;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;

/**
 * Created by sairam on 31/1/17.
 */

@RunWith(Parameterized.class)
public class LoginActivityTest {
    private final String alertMessage,password,username;

    @Rule
    public ActivityTestRule<MainActivity> activityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
//        List<String> usernames = new ArrayList<>();
//        List<String> passwords = new ArrayList<>();
//        List<String> alertMessages = new ArrayList<>();
//
//        usernames.add("sairam");
//        usernames.add("");
//        usernames.add(null);
//        usernames.add("sairam");
//        usernames.add("sairam");
//
//        passwords.add("");
//        passwords.add("sairam");
//        passwords.add("sairam");
//        passwords.add(null);
//        passwords.add("sairam");
//
//        alertMessages.add("Validation Failed");
//        alertMessages.add("Validation Failed");
//        alertMessages.add("Validation Failed");
//        alertMessages.add("Validation Failed");
//        alertMessages.add("Validation OK");
        return Arrays.asList(new Object[][]{
                {"sairam","","Validation Failed"},
                {"","sairam","Validation Failed"},
                {"sairam","sairam","Validation OK"}
        });
    }

    public LoginActivityTest(String username,String password,String alertMessage){
        this.username = username;
        this.password = password;
        this.alertMessage = alertMessage;
    }

    @Test
    public void clickLoginButton_ShouldShowValidationToast() throws Exception{
            onView(withId(R.id.username)).perform(typeText(username)).perform(closeSoftKeyboard());
            onView(withId(R.id.password)).perform(typeText(password)).perform(closeSoftKeyboard());
            Thread.sleep(250);
            onView(withId(R.id.login_button)).perform(click());
//            onView(withId(R.id.alert_message)).check(matches(withText(alertMessage)));
            onView(withText(alertMessage)).inRoot(new ToastMatcher()).check(matches(isDisplayed()));
    }
}
