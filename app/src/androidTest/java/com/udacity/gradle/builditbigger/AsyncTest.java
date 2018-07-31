package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.text.TextUtils;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;

/**
 * Created by duynguyen on 7/30/18.
 */

public class AsyncTest {
    String mJoke;
    @Test
    public void aTest () throws InterruptedException {
        final CountDownLatch signal = new CountDownLatch(1);
        EndpointsAsyncTask task = new EndpointsAsyncTask();
        task.setListener(new EndpointsAsyncTask.GetTaskListener() {
            @Override
            public void onComplete(String joke) {
                mJoke = joke;
                signal.countDown();
            }
        }).execute();
        signal.await();
        assertFalse(TextUtils.isEmpty(mJoke));
    }
}
