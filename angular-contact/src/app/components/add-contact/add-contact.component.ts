import { Component } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Contact } from 'src/app/model/contact.model';
import { ContactService } from 'src/app/services/contact.service';

@Component({
  selector: 'app-add-contact',
  templateUrl: './add-contact.component.html',
  styleUrls: ['./add-contact.component.css']
})
export class AddContactComponent {
  error = null;
  contactForm: FormGroup;
  contact: Contact = {
    id: 0,
    firstName: '',
    lastName: '',
    email: '',
    phone: '',
    address: '',
    company: '',
    jobTitle: '',
    birthday: ''
  };

  constructor(private contactService: ContactService, private formBuilder: FormBuilder, private router: Router) {
    this.contactForm = this.formBuilder.group({
      firstName: ['', [Validators.required, Validators.minLength(2)]],
      lastName: ['', Validators.minLength(2)],
      email: ['', [Validators.email]],
      phone: ['', [Validators.required, Validators.pattern(/^[0-9]{10,15}$/)]],
      address: [''],
      company: [''],
      jobTitle: [''],
      birthday: ['', [this.validateBirthday]]
    });
  }

  // Validator personnalisé pour vérifier la date de naissance
  validateBirthday(control: AbstractControl): { [key: string]: any } | null {
    if (!control.value) return null;
    const birthday = new Date(control.value);
    const today = new Date();
    return birthday > today ? { invalidDate: 'La date de naissance ne peut pas être dans le futur' } : null;
  }

  // Fonction pour récupérer les messages d'erreur
  getErrorMessage(control: AbstractControl | null, fieldName: string): string {
    if (!control) return '';

    if (control.hasError('required')) {
      return `${fieldName} est requis.`;
    }
    if (control.hasError('minlength')) {
      return `${fieldName} doit contenir au moins ${control.getError('minlength').requiredLength} caractères.`;
    }
    if (control.hasError('email')) {
      return `L'email n'est pas valide.`;
    }
    if (control.hasError('pattern')) {
      return `Format invalide pour ${fieldName}.`;
    }
    if (control.hasError('invalidDate')) {
      return `La date de naissance ne peut pas être dans le futur.`;
    }
    return '';
  }



  addContact() {
    console.log(this.contactForm.value);
    if (this.contactForm.valid) {
      const newContact = new Contact(0, this.contactForm.value.firstName,
        this.contactForm.value.lastName,
        this.contactForm.value.email,
        this.contactForm.value.phone,
        this.contactForm.value.address,
        this.contactForm.value.company,
        this.contactForm.value.jobTitle,
        this.contactForm.value.birthday, 0, 0
      );
      this.contactService.addContact(newContact).subscribe({
        next: () => {
          // Redirection après succès
          this.router.navigateByUrl('contacts');
        },
        error: (err) => (this.error = err.message),
        complete: () => (this.error = null),
      });
    }
  }
}