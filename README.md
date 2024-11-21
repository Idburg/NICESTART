PROYECTO NICESTART
==================
El objetivo de este proyecto fue realizar el boceto de una aplicacion de registro básica para aprender
a utilizar Android Studio, particularmente la implementación de layouts y la conectividad entre sí. En este proyecto se 
ha utilizado el ConstraintLayout englobando todos los objetos para ajustar a medida las dimensiones de éstos.

Activity Login
--------------
El diseño de esta actividad está realizado con componentes del Material Design proporiconados por defecto por
Android Studio. Se han realizado dos activites distintas teniendo en cuenta la orientación del dispositivo:

**Vista Perfil**

![image](https://github.com/user-attachments/assets/463fb2fb-6265-4dc5-9452-3aae3d595746)

**Vista Panorama**

![image](https://github.com/user-attachments/assets/fb6a7d9e-2738-4934-9cdb-6bf53276470d)

Se puede apreciar que los colores están personalizados y el fondo de pantalla es un gradiente creado a partir de 
ellos. Esto se puede realizar creando ficheros xml en la carpeta @drawable; en este caso siendo colors.xml y gradient.xml:

```xml
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <color name="purple_200">#FFBB86FC</color>
    <color name="fucsia_200">#F12369</color>
    <color name="fucsia_700">#4D0A20</color>
    <color name="purple_500">#FF6200EE</color>
    <color name="purple_700">#FF3700B3</color>
    <color name="teal_200">#FF03DAC5</color>
    <color name="teal_700">#FF018786</color>
    <color name="black">#FF000000</color>
    <color name="white">#FFFFFFFF</color>
</resources>
```
```xml
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android" android:shape="rectangle">
    <gradient
        android:startColor="@color/fucsia_200"
        android:endColor="@color/purple_200"
        android:angle="270">
        </gradient>
</shape>
```

En cuanto a los botones, se ha creado un fichero styles.xml en donde se han realizado las siguientes especificaciones:

```xml
<<?xml version="1.0" encoding="utf-8"?>
<resources>
    <style name="buttonFlat">
        <item name="android:layout_width">0dp</item>
        <item name="android:layout_height">60dp</item>
        <item name="android:backgroundTint">@color/white</item>
        <item name="android:textColor">@color/fucsia_700</item>
    </style>

    <style name="buttonOutlined" parent="Widget.MaterialComponents.Button.OutlinedButton">
        <item name="android:layout_width">0dp</item>
        <item name="android:layout_height">wrap_content</item>
        <item name="android:textColor">@android:color/white</item>
        <item name="cornerRadius">8dp</item>
        <item name="strokeColor">@android:color/white</item>
    </style>
</resources>
```

La funcionalidad del Glide, que reemplaza el gradiente, se debe realizar en el archivo Java asociado con la actividad y,
en este caso, tendrá el siguiente código adicional al ya generado:

```java
ImageView bGirl = findViewById(R.id.girl);

        Glide.with(this)
                .load(R.drawable.girl)
                .transition(DrawableTransitionOptions.withCrossFade(2000))
                .centerCrop()
                .placeholder(new ColorDrawable(this.getResources().getColor(R.color.purple_200)))
                .into(bGirl);
```

> Para utilizar Glide, se deben importan en build.gradle.kts(:app)
```kts
dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)

    implementation(libs.lottie)

    implementation(libs.glide)
    implementation(libs.glide.transformations)
    implementation(libs.swiperefreshlayout)
    annotationProcessor(libs.compiler)

    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    
}
```
```toml
[versions]
agp = "8.6.0"
compiler = "4.14.2"
glide = "4.16.0"
glideTransformations = "4.3.0"
junit = "4.13.2"
junitVersion = "1.2.1"
espressoCore = "3.6.1"
appcompat = "1.7.0"
lottie = "6.6.0"
material = "1.12.0"
activity = "1.9.2"
constraintlayout = "2.1.4"
swiperefreshlayout = "1.1.0"

[libraries]
compiler = { module = "com.github.bumptech.glide:compiler", version.ref = "compiler" }
glide = { module = "com.github.bumptech.glide:glide", version.ref = "glide" }
glide-transformations = { module = "jp.wasabeef:glide-transformations", version.ref = "glideTransformations" }
junit = { group = "junit", name = "junit", version.ref = "junit" }
ext-junit = { group = "androidx.test.ext", name = "junit", version.ref = "junitVersion" }
espresso-core = { group = "androidx.test.espresso", name = "espresso-core", version.ref = "espressoCore" }
appcompat = { group = "androidx.appcompat", name = "appcompat", version.ref = "appcompat" }
lottie = { module = "com.airbnb.android:lottie", version.ref = "lottie" }
material = { group = "com.google.android.material", name = "material", version.ref = "material" }
activity = { group = "androidx.activity", name = "activity", version.ref = "activity" }
constraintlayout = { group = "androidx.constraintlayout", name = "constraintlayout", version.ref = "constraintlayout" }
swiperefreshlayout = { group = "androidx.swiperefreshlayout", name = "swiperefreshlayout", version.ref = "swiperefreshlayout" }

[plugins]
android-application = { id = "com.android.application", version.ref = "agp" }
```

Activity Signup
---------------
El diseño de esta actividad es muy parecido al del activity login pero aquí se pueden apreciar más campos para la
entrada de texto.

![image](https://github.com/user-attachments/assets/2f745b02-ea77-425d-9671-ec005648d774)

Se puede apreciar en ambas actividades la aparición de iconos a la izquierda del texto, lo cual se puede implementar
con la propiedad app:startIconDrawable.

```xml
<com.google.android.material.textfield.TextInputLayout
        android:id="@+id/name"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginTop="48dp"
        app:layout_constraintEnd_toEndOf="@id/guide2"
        app:layout_constraintStart_toStartOf="@id/guide1"
        app:layout_constraintTop_toBottomOf="@id/icon_img"
        app:startIconDrawable="@drawable/user_icon"
        >

        <EditText
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:alpha="0.6"
            android:background="@color/white"
            android:hint="@string/username" />

    </com.google.android.material.textfield.TextInputLayout>
```

Activity Profile
----------------
Esta actividad es un boceto de una ventana de Profile donde el usuario consultará sus datos personales.
Es un diseño muy sencillo y existe para probar el uso de la librería de animaciones Lottie para darle estilo a la imagen del avatar.

![image](https://github.com/user-attachments/assets/0855a88d-fb70-49c0-8df9-383c8a2361b6)

> El enlace al GitHub se puede poner en el `strings.xml` de la siguiente forma:
> 
>  `<string name="github">Sígueme en <a href="https://github.com/Idburg">GitHub</a></string>`


Previamente se debe importar Lottie al proyecto de la misma forma que el Glide. Para más detalles, consulta [la documentación original][1]

[1]: https://airbnb.io/lottie/#/android "doc"

Para implementarlo, se debe primero descargar el archivo `.json` de la web de Lottie, crear una carpeta *raw* dentro de *res* e introducir aquí el archivo.
Una vez hecho, en el xml de la actividad donde se busca implementarlo, se introduce lo siguiente:

```xml
<com.airbnb.lottie.LottieAnimationView
        android:layout_width="120dp"
        android:layout_height="120dp"
        android:id="@+id/profile"
        app:lottie_rawRes="@raw/user_anim"
        app:lottie_autoPlay="true"
        app:layout_constraintEnd_toStartOf="@id/guide2"
        app:layout_constraintStart_toEndOf="@id/guide1"
        app:layout_constraintTop_toBottomOf="@+id/tituloMain"
    />
```

>Se puede poner `app:lottie_loop = "true"` para que se repita el bucle infinitamente

Activity Splash
---------------
Esta actividad es la pantalla de carga de la aplicación y sirve como un "testing ground" para el uso de animaciones, que se detallará más después.

![image](https://github.com/user-attachments/assets/71bea20d-6f31-452b-af16-b4148fd8390f)


Activity Main
-------------
Esta actividad, por muy simple que parezca tiene muchísimos componentes dinámicos, tanto para la imagen de la web como para la ActionBar

![image](https://github.com/user-attachments/assets/cbf94cb0-abfb-4049-a1ce-f0a69c282f12)

Para empezar, la imagen proviene de una pagina web que por cada vez que se refresca se cambia, por lo cual en el .xml se debe contener
en un *SwipeRefreshLayout* que proporcionará esa función al usuario.

![image](https://github.com/user-attachments/assets/9a272844-61d3-4d54-9f38-464827a4c513)

Dinámicamente, se implemeta en el `MainActivity.java` de la siguiente forma:

![image](https://github.com/user-attachments/assets/e872185c-6637-42d2-bf34-796040f3dfcb)

![image](https://github.com/user-attachments/assets/4dfb4581-b92f-4d87-85d2-981958d4130f)

>Esta interfaz es necesaria especificarla, aunque se puede prescindir de los mensajes del Snackbar

En cuanto a la ActionBar, aparte de configurarlo en el Manifest (más detalles en el apartado de interactividad), se deben configurar varios aspectos:

![image](https://github.com/user-attachments/assets/131154a9-e38f-49f9-b08d-0cba37959a44)
> Se pueden añadir iconos a las opciones al igual que con los botones

Lo primero, se debe crear un fichero XML que contenga las opciones del ActionBar en una carpeta llamada menu en el res. Después, como se puede apreciar, se deben
añadir tanto las dos opciones del actionbar como las subopciones de Settings en distintos items con sus propios IDs y títulos. Dinámicamente, se debe realizar de 
la siguiente manera:

![image](https://github.com/user-attachments/assets/8d26511d-736b-4deb-9e9a-19c9c226619a)
> El menú de contexto para *ActionBar*

![image](https://github.com/user-attachments/assets/228256bc-920d-4cb0-9e77-a584010369c0)
> El menú de opciones para *Settings* 

En este último se utiliza una función que lanza una alerta al pulsar la quinta opción, presentando al usuario con 3 opciones:

![image](https://github.com/user-attachments/assets/706fbb44-5438-4c34-a6c9-d7d30233420e)

Para codificar lo siguiente en java, se ha utilizado la siguiente función, la cual lanza un Intent cuando se pulsa "Proceed":

```java
 public void showAlertDialogButtonClicked(MainActivity mainActivity) {

        // setup the alert builder
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(this);

//        //el dialogo estandar tiene título/icono pero podemos sustituirlo por un XML a medida
        builder.setTitle("Precaución!");
        builder.setMessage("Dónde desea ir?");
        builder.setIcon(R.drawable.user_icon);
        builder.setCancelable(false);

        // un XML a medida para el diálogo
        //builder.setView(getLayoutInflater().inflate(R.layout.alertdialog_view, null));

        // add the buttons

        builder.setPositiveButton("Proceed", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // do something like...
                Intent intent = new Intent(MainActivity.this, Profile.class);
                startActivity(intent);
                dialog.dismiss();

            }
        });

        builder.setNegativeButton("Do nothing", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                // do something like...

                dialog.dismiss();
            }
        });

        builder.setNeutralButton("Other", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                // do something like...
                System.exit(0);

                dialog.dismiss();
            }
        });

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }
```

Interactividad
--------------
Dado que se buscaba añadir interactividad entre las actividades, lo primero que se hizo fue especificar qué botón lleva a qué sitio y
qué actividad lleva ActionBar y no. Para ello, se debe configurar el `AndroidManifest.xml` de la siguiente forma:

![image](https://github.com/user-attachments/assets/eb309bfa-b0cc-49c6-9d87-4dd6a72d0bf1)

En esta imagen del AndroidManifest se puede apreciar varias:
* El uso de :parentActivityName para especificar donde el retorno de signup a login mediante una flecha en la ActionBar
* La propiedad :exported = true para permitir la interactividad
* La implementacion de temas específicos para cada actividad

> Los temas para las ActionBars se encuentran, detallan y/o añaden en themes.xml
> ![image](https://github.com/user-attachments/assets/566b89ab-8e72-446b-8306-1fdbadc17c1a)

Una vez realizada la interactividad con ActionBar, se debe implementar código Java para las interacciones que requieren pulsar un botón.
Para ello se debe utilizar un objeto de la clase Intent y englobar la acción en un método:

![image](https://github.com/user-attachments/assets/95f3fbff-2fa9-4cfd-8b60-613e77d27f0b)

> Debe existir la propiedad onclick (o cualquier otra que se busca) igualada al nombre del método previamente en el xml de la actividad

>![image](https://github.com/user-attachments/assets/df919b9c-c999-4393-8428-764b08ec9150)


Animaciones Sencillas 
---------------------
Con el objetivo de añadir fluidez a la aplicación, se ha explorado añadir animaciones mediante el propio Android Studio. Para ello,
se pueden crear ficheros XML en la carpeta anim:

![image](https://github.com/user-attachments/assets/2503c727-09c7-4789-aace-5c2a3d0e6dec)

Una vez visualizadas las animaciones, para traducirlo en código se puede realizar lo siguiente:

![image](https://github.com/user-attachments/assets/fc79cffe-5cbb-4a9f-a8b1-505ee76c87ca)

En este ejemplo se puede observar una animación de parpadeo o "blink" donde se agrupan tres animaciones distintas en una misma etiqueta 
`<set>` para lograr el efecto ya descrito.
> La etiqueta `<scale>` afecta el tamaño del objeto mediante 2 escalas, una para el eje X y otra para el eje Y
>
>> Las propiedades `toPivotX` y 'toPivotY' indican el punto de referencia por el cual se realizará la escala, que en este caso es el centro
>
> La etiqueta `<transform` afecta el desplazamiento que tendrá el objeto en los dos ejes
>
>> Los valores positivos en la variable Y hacen que el objeto se mueva hacia abajo
> 
> La etiqueta `<alpha>` afecta la opacidad del objeto
> 
>> Detro de ella se debe poner la propiedad `android:repeatMode="reverse"` para que parezca que está "parpadeando" el objeto

Una vez hechas las animaciones, para implementarlas se debe utilizar AnimatioUtils de la siguiente forma:

![image](https://github.com/user-attachments/assets/4b794402-8580-4e5e-9610-201e41f7b5ce)

