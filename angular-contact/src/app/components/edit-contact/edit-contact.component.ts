import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Contact } from 'src/app/model/contact.model';
import { ContactService } from 'src/app/services/contact.service';

@Component({
  selector: 'app-edit-contact',
  templateUrl: './edit-contact.component.html',
  styleUrls: ['./edit-contact.component.css']
})
export class EditContactComponent implements OnInit {
  contactForm!: FormGroup;
  contactId!: number;

  constructor(
    private fb: FormBuilder,
    private contactService: ContactService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.contactId = this.route.snapshot.params['id'];

    this.contactForm = this.fb.group({
      firstName: ['', Validators.required],
      lastName: [''],
      email: ['', [Validators.email]],
      phone: ['', Validators.required],
      address: [''],
      company: [''],
      jobTitle: [''],
      birthday: ['', [this.validateBirthday]]
    });

    this.contactService.getContacts().subscribe(contacts => {
      const contact = contacts.find(c => c.id == this.contactId);
      if (contact) this.contactForm.patchValue(contact);
    });
  }

  updateContact() {
    if (this.contactForm.valid) {
      this.contactService.editContact(this.contactId, this.contactForm.value).subscribe(() => {
        alert('Contact mis à jour avec succès !');
        this.router.navigate(['']);
      });
    }
  }

  getErrorMessage(control: AbstractControl | null, fieldName: string): string {
    if (!control) return '';

    if (control.hasError('required')) {
      return `${fieldName} est requis.`;
    }
    if (control.hasError('email')) {
      return `Veuillez entrer un email valide`;
    }
    if (control.hasError('invalidDate')) {
      return `La date de naissance ne peut pas être dans le futur.`;
    }
    return '';
  }

  // Validator personnalisé pour vérifier la date de naissance
  validateBirthday(control: AbstractControl): { [key: string]: any } | null {
    if (!control.value) return null;
    const birthday = new Date(control.value);
    const today = new Date();
    return birthday > today ? { invalidDate: 'La date de naissance ne peut pas être dans le futur' } : null;
  }
  
}