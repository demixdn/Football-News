package com.github.rules.interactor;

import com.github.rules.executor.UIScheduler;
import com.github.rules.executor.WorkerScheduler;
import com.github.rules.repository.NewsRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;

/**
 * Date: 16.02.2017
 * Time: 16:58
 *
 * @author Aleks Sander
 *         Project FootballNews
 */
@RunWith(MockitoJUnitRunner.class)
public class GetFootballNewsesTest {

    private GetFootballNewses getFootballNewses;

    @Mock
    private UIScheduler mockUiScheduler;
    @Mock
    private WorkerScheduler mockWorkerScheduler;
    @Mock
    private NewsRepository mockNewsRepository;

    @Before
    public void setUp() throws Exception {
        getFootballNewses = new GetFootballNewses(mockUiScheduler, mockWorkerScheduler, mockNewsRepository);
    }

    @Test
    public void testGetFootballNewsesUseCaseObservableHappyCase(){
        getFootballNewses.buildUseCaseObservable(null);

        verify(mockNewsRepository).getNews(null);
        verifyNoMoreInteractions(mockNewsRepository);
        verifyZeroInteractions(mockUiScheduler);
        verifyZeroInteractions(mockWorkerScheduler);
    }

}