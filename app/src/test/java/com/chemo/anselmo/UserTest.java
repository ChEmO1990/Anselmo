package com.chemo.anselmo;


import com.chemo.anselmo.models.UserResponse;
import com.chemo.anselmo.rest.ApiService;
import com.chemo.anselmo.utils.ApiUtils;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import rx.observers.TestSubscriber;
import static org.assertj.core.api.Assertions.assertThat;



public class UserTest {
    ApiService interactor;

    @Before
    public void setUp() {
        interactor = ApiUtils.getUserService();
    }

    @Test
    public void test_getRestService() throws Exception {
        TestSubscriber<List<UserResponse>> subscriber = TestSubscriber.create();
        interactor.getUsers().subscribe(subscriber);
        subscriber.assertNoErrors();
        subscriber.assertCompleted();
    }

    @Test
    public void test_getModelFromService() throws Exception {
        TestSubscriber<List<UserResponse>> subscriber = TestSubscriber.create();
        interactor.getUsers().subscribe(subscriber);
        List<List<UserResponse>> items = subscriber.getOnNextEvents();
        assertThat( items.get(0)).hasOnlyElementsOfType(UserResponse.class);
    }

    @Test
    public void test_getItemsCount() throws Exception {
        TestSubscriber<List<UserResponse>> subscriber = TestSubscriber.create();
        interactor.getUsers().subscribe(subscriber);
        subscriber.assertNoErrors();
        subscriber.assertCompleted();
        List<List<UserResponse>> items = subscriber.getOnNextEvents();
        assertThat(items.get(0)).hasSize(10); //The service always return 10 items.
    }
}