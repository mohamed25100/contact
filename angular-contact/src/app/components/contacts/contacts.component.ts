import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Contact } from 'src/app/model/contact.model';
import { ContactService } from 'src/app/services/contact.service';

@Component({
  selector: 'app-contacts',
  templateUrl: './contacts.component.html',
  styleUrls: ['./contacts.component.css']
})
export class ContactsComponent implements OnInit{
  listContacts: Contact[] = [];
  searchTerm: string = '';
  error = null;

  constructor(private contactService : ContactService,private router :Router) {}

  ngOnInit(): void {
    this.getAllContacts();
  }

  getAllContacts() {
    this.contactService.getContacts().subscribe({
      next: (data) => {
        // Tri par ID du plus petit au plus grand
        this.listContacts = data.sort((a, b) => a.id - b.id);
        //console.log(this.listContacts);
        console.log(data);
      },
      error: (err) => (this.error = err.message),
      complete: () => (this.error = null),
    });
  }

  filteredContacts(): Contact[] {
    if (!this.searchTerm) return this.listContacts;

    const lowerSearch = this.searchTerm.toLowerCase();
    return this.listContacts.filter(contact =>
      contact.firstName?.toLowerCase().includes(lowerSearch) ||
      contact.lastName?.toLowerCase().includes(lowerSearch)
    );
  }

  editContact(id: number) {
    console.log('Modification du contact avec ID:', id);
    // Rediriger vers une page d'édition
    this.router.navigate(['/contact/edit', id]);
  }
  
  deleteContact(id: number) {
    if (confirm("Êtes-vous sûr de vouloir supprimer ce contact ?")) {
      this.contactService.deleteContact(id).subscribe({
        next: () => {
          this.listContacts = this.listContacts?.filter(contact => contact.id !== id);
          console.log(`Contact avec ID ${id} supprimé`);
        },
        error: (err: any) => console.error("Erreur lors de la suppression :", err),
      });
    }
  }
  
}
