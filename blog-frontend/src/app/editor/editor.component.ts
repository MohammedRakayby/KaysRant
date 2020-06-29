import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { PreviewComponent } from './preview/preview.component';
import { MatDialog } from '@angular/material/dialog';
import Quill from 'quill';

@Component({
  selector: 'app-editor',
  templateUrl: './editor.component.html',
  styleUrls: ['./editor.component.css']
})
export class EditorComponent implements OnInit {
  editorStyle = {
    'height': '50vh',
    'backgroundColor': '#2125290d'
  }
  config = {
    toolbar: []
  }
  counter: number;
  content: string;
  constructor(public dialog: MatDialog) { }
  editorForm: FormGroup;
  ngOnInit(): void {
    this.editorForm = new FormGroup({
      'editor': new FormControl('')
    })
  }
  openDialog(content: any) {
    const dialogRef = this.dialog.open(PreviewComponent, {
      height: '70vh',
      width: '50vw',
      data: content
    }
    );

    // dialogRef.afterClosed().subscribe(result => {
    //   console.log(`Dialog result: ${result}`);
    // });
  }
  onSubmit() {
    // console.log(this.editorForm.get('editor').value);
  }
  count(e) {
    this.counter = e.editor.getLength() - 1;
  }
  preview() {
    this.content = this.editorForm.get('editor').value;
    this.openDialog(this.content);
    console.log(this.content);
    //add this to modal
  }


}
