import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ContactsComponent } from './components/contacts/contacts.component';
import { AddContactComponent } from './components/add-contact/add-contact.component';
import { EditContactComponent } from './components/edit-contact/edit-contact.component';

const routes: Routes = [
  {
    path: 'contacts', component: ContactsComponent
  },
  {
    path: 'contact/add', component: AddContactComponent
  }
  ,
  {
    path: 'contact/edit/:id', component: EditContactComponent
  },{
    path: '', redirectTo: 'contacts', pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
