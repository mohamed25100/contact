import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { Contact } from '../model/contact.model';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ContactService {

  constructor(private http: HttpClient) { }

  // Récupérer la liste des contacts
  getContacts(): Observable<Contact[]> {
    return this.http.get<Contact[]>(environment.host + "/contacts");
  }

  // Ajouter un contact
  addContact(contact: Contact): Observable<Contact> {
    return this.http.post<Contact>(environment.host + "/contact", contact);
  }

  // Modifier un contact existant
  editContact(id: number, contact: Contact): Observable<Contact> {
    return this.http.put<Contact>(environment.host + "/contact/" + id, contact);
  }

  // Supprimer un contact
  deleteContact(id: number): Observable<void> {
    return this.http.delete<void>(`${environment.host}/contact/${id}`);
  }
}
