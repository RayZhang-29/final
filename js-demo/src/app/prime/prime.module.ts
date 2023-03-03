import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PrimeHomeComponent } from './prime-home/prime-home.component';
import { MusicComponent } from './music/music.component';
import { VideoComponent } from './video/video.component';
import {RouterModule, Routes} from "@angular/router";

const routes: Routes = [
  {
    path: '',
    component: PrimeHomeComponent,
    children: [
      {
        path: 'music',
        component: MusicComponent
      },
      {
        path: 'video',
        component: VideoComponent
      }
      // ???
      // {
      //   path: '**',
      //   redirectTo: ''
      // }
    ]
  }
]

// lazy loading, app-module webpack bundle
@NgModule({
  declarations: [
    PrimeHomeComponent,
    MusicComponent,
    VideoComponent
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(routes)
  ],
  exports: [RouterModule]
})
export class PrimeModule { }
