package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import O4.p;
import O4.u;
import V4.e;
import Z4.a;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Base64;

public class JobInfoSchedulerService extends JobService {
    public final /* synthetic */ void b(JobParameters jobParameters) {
        jobFinished(jobParameters, false);
    }

    public boolean onStartJob(JobParameters jobParameters) {
        String string = jobParameters.getExtras().getString("backendName");
        String string2 = jobParameters.getExtras().getString("extras");
        int i = jobParameters.getExtras().getInt("priority");
        int i2 = jobParameters.getExtras().getInt("attemptNumber");
        u.f(getApplicationContext());
        p.a d = p.a().b(string).d(a.b(i));
        if (string2 != null) {
            d.c(Base64.decode(string2, 0));
        }
        u.c().e().v(d.a(), i2, new e(this, jobParameters));
        return true;
    }

    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
