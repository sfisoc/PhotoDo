import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';
import { Camera, CameraOptions } from '@ionic-native/camera';



@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {

public flip: boolean;
public imgsrc = "assets/imgs/logo.png";
public base64Image: string;

 options: CameraOptions = {
  quality: 100,
  destinationType: this.camera.DestinationType.DATA_URL,
  encodingType: this.camera.EncodingType.JPEG,
  mediaType: this.camera.MediaType.PICTURE
}

  constructor(public navCtrl: NavController, private camera: Camera) {
    this.flip =false;

  }

  public fliper ()
  {
      this.flip = !this.flip;
      console.log(this.imgsrc);
  }

  
  

  public takePic()
  {
  
    this.camera.getPicture(this.options).then((imageData) => {
      // imageData is a base64 encoded string
        this.base64Image = "data:image/jpeg;base64," + imageData;
        this.imgsrc = this.base64Image;
    }, (err) => {
        console.log(err);
    });
  }

}
