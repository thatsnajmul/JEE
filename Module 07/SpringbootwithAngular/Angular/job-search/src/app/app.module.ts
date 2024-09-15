import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { JobPostComponent } from './job-posting/job-post.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { JobPostingListComponent } from './job-posting-list/job-posting-list.component';
import { JobPostingDetailComponent } from './job-posting-detail/job-posting-detail.component';
import { JobPostingEditComponent } from './job-posting-edit/job-posting-edit.component';

@NgModule({
  declarations: [
    AppComponent,
    JobPostComponent,
    JobPostingListComponent,
    JobPostingDetailComponent,
    JobPostingEditComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    provideClientHydration()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
