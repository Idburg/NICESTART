PROYECTO NICESTART
==================
El objetivo de este proyecto fue realizar el boceto de una aplicacion de registro básica para aprender
a utilizar Android Studio, particularmente la implementación de layouts y la conectividad entre sí. En este proyecto se 
ha utilizado el ConstraintLayout englobando todos los objetos para ajustar a medida las dimensiones de éstos. Además, se explora 
el uso de varias animaciones, Toast, SnackBar y alertas para mejorar la interactividad con el usuario.

Activity Login
--------------
El diseño de esta actividad está realizado con componentes del Material Design proporiconados por defecto por
Android Studio. Se han realizado dos activites distintas teniendo en cuenta la orientación del dispositivo:

**Vista Perfil**

![image](https://github.com/user-attachments/assets/463fb2fb-6265-4dc5-9452-3aae3d595746)

**Vista Panorama**

![image](https://github.com/user-attachments/assets/fb6a7d9e-2738-4934-9cdb-6bf53276470d)

Para cambiar entre las dos activites en este caso particular, se debe implementar el siguiente código en el método `onCreate()`
de *ambas*:

```java
int orientation = getResources().getConfiguration().orientation;
if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
    Intent intent = new Intent(this, HorizontalLogin.class);
    startActivity(intent);
    finish();
} else if (orientation == Configuration.ORIENTATION_PORTRAIT) {
    Intent intent = new Intent(this, Login.class);
    startActivity(intent);
    finish();
        }
```
> Nota: es muy recomendable utilizar sólo una única vista para esto dado que en ese caso Android lo hace ya de por sí siempre
> que se esté utilizando ConstraintLayout o incluso LinearLayout (ver [documentación][1])

[1]: https://developer.android.com/develop/ui/views/layout/responsive-adaptive-design-with-views

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

Para utilizar Glide, o cualquier librería externa, se deben importar en build.gradle.kts(Module:app)

```kts
dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)

    implementation(libs.lottie)

    implementation (libs.com.squareup.okhttp3.okhttp)
    implementation (libs.retrofit)
    implementation (libs.converter.gson)

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


Previamente se debe importar Lottie al proyecto de la misma forma que el Glide. Para más detalles, consulta [la documentación original][2]

[2]: https://airbnb.io/lottie/#/android "doc"

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

```xml
<androidx.swiperefreshlayout.widget.SwipeRefreshLayout
        android:id="@+id/myswipe"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        >

        <WebView
            android:id="@+id/imageweb"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"

            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintTop_toTopOf="parent"
            />
        <TextView
            android:id="@+id/buenas"
            android:layout_marginTop="24dp"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@string/buenos_d_as"
            android:textSize="16sp"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintTop_toBottomOf="@id/imageweb"
            />
    </androidx.swiperefreshlayout.widget.SwipeRefreshLayout>
```
> Nota: el TextView está por si el enlace a la web es erróneo, sino estará siempre detrás del WebView,
> que es un contenedor de contenido extraido por páginas web. Se debe habilitar la funcionalidad en el manifest (ver **Interactividad**)

Dinámicamente, se implemeta en el `MainActivity.java` de la siguiente forma:

```java
TextView mycontext = (TextView) findViewById(R.id.buenas);
        registerForContextMenu(mycontext);

        swipeLayout = findViewById(R.id.myswipe);
        swipeLayout.setOnRefreshListener(mOnRefreshListener);

        miViewWeb = (WebView) findViewById(R.id.imageweb);
        WebSettings webSettings = miViewWeb.getSettings();
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        miViewWeb.loadUrl("https://thispersondoesnotexist.com");
```
```java
protected SwipeRefreshLayout.OnRefreshListener
            mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {

        @Override
        public void onRefresh(){

            final ConstraintLayout mLayout = findViewById(R.id.myMainConstraint);

            Snackbar snackbar = Snackbar
                    .make(mLayout,"fancy a Snack while you refresh?",Snackbar.LENGTH_SHORT)
                    .setAction("UNDO", new View.OnClickListener() {
                        @Override
                        public void onClick(View view){
                            Snackbar snackbar1 = Snackbar.make(mLayout, "Action is restored!",Snackbar.LENGTH_SHORT);
                            snackbar1.show();
                        }
                    });
            snackbar.show();

            miViewWeb.reload();
            swipeLayout.setRefreshing(false);
        }
    };
```

>Esta interfaz es necesaria especificarla, aunque se puede prescindir de los mensajes del Snackbar (no recomendable)

En cuanto a la ActionBar, aparte de configurarlo en el Manifest (más detalles en el apartado de interactividad), se deben configurar varios aspectos:

```xml
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">
    <item
        android:id="@+id/item2"
        android:title="@string/settings"
        app:showAsAction="never"
        >
        <menu>
            <item
                android:id="@+id/item3"
                android:title="@string/bottom_app_bar"
                app:showAsAction="never" />

            <item
                android:id="@+id/item4"
                android:title="@string/bottom_navigation"
                app:showAsAction="never" />


            <item
                android:id="@+id/item5"
                android:title="@string/signout"
                app:showAsAction="never"
                android:icon="@drawable/ic_door"/>
        </menu>
    </item>

    <item
        android:id="@+id/item1"
        android:title="@string/copy"
        app:showAsAction="ifRoom"
        >
    </item>
</menu>
```
> Se pueden añadir iconos a las opciones al igual que con los botones

Lo primero, se debe crear un fichero XML que contenga las opciones del ActionBar en una carpeta llamada menu en el res. Después, como se puede apreciar, se deben
añadir tanto las dos opciones del actionbar como las subopciones de Settings en distintos items con sus propios IDs y títulos. Dinámicamente, se debe realizar de 
la siguiente manera:

```java
@Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        getMenuInflater().inflate(R.menu.menu_context, menu);
    }

@Override
    public boolean onContextItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        if(id == R.id.item1)
        {
            Toast toast = Toast.makeText(this,"Infecting",Toast.LENGTH_LONG);
            toast.show();
        }
        if(id == R.id.item2)
        {
            Toast toast2 = Toast.makeText(this,"Fixing",Toast.LENGTH_LONG);
            toast2.show();


            Intent intent = new Intent(this, Profile.class);
            startActivity(intent);

        }


        return super.onContextItemSelected(item);
    }
```
> El menú de contexto para *ActionBar*

```java
@Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_aptbar, menu);
        return true;
    }

@Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        if(id == R.id.item1)
        {
            Toast toast = Toast.makeText(this, "Infecting", Toast.LENGTH_LONG);
            toast.show();
        }
        if(id == R.id.item2)
        {
            Toast toast = Toast.makeText(this, "Fixing", Toast.LENGTH_LONG);
            toast.show();
        }
        if(id == R.id.item3)
        {
            Toast toast = Toast.makeText(this, "Profile", Toast.LENGTH_LONG);
            toast.show();
        }
        if(id == R.id.item4)
        {
            Toast toast = Toast.makeText(this, "Item4", Toast.LENGTH_LONG);
            toast.show();
        }
        if(id == R.id.item5)
        {
            showAlertDialogButtonClicked(MainActivity.this);
        }

        return super.onOptionsItemSelected(item);
    }
```
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

Interactividad y Funcionalidad
==============================
Dado que se buscaba añadir interactividad entre las actividades, lo primero que se hizo fue especificar qué botón lleva a qué sitio y
qué actividad lleva ActionBar y no. Para ello, se debe configurar el `AndroidManifest.xml` de la siguiente forma:

```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools">

    <uses-permission android:name="android.permission.INTERNET" />

    <application
        android:allowBackup="true"
        android:dataExtractionRules="@xml/data_extraction_rules"
        android:fullBackupContent="@xml/backup_rules"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/Theme.NICESTART"
        tools:targetApi="31">
        <activity
            android:name=".Splash"
            android:exported="true" >
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
        <activity
            android:name=".Profile"
            android:exported="true" />
        <activity
            android:name=".HorizontalLogin"
            android:exported="true"
            android:screenOrientation="landscape"/>
        <activity
            android:name=".Signup"
            android:exported="true"
            android:parentActivityName=".Login"
            android:theme="@style/Theme.NICESTART.ActionBar" />
        <activity
            android:name=".Login"
            android:exported="true"
            android:screenOrientation="portrait"/>
        <activity
            android:name=".MainActivity"
            android:exported="true"
            android:theme="@style/Theme.NICESTART.ActionBar" />

        <meta-data
            android:name="preloaded_fonts"
            android:resource="@array/preloaded_fonts" />
    </application>

</manifest>
```

En esta imagen del AndroidManifest se puede apreciar varias:
* El uso de :parentActivityName para especificar donde el retorno de signup a login mediante una flecha en la ActionBar
* La propiedad :exported = true para permitir la interactividad
* La implementacion de temas específicos para cada actividad
* El uso de `android:screenOrientation` para fijar la orientación del `activity_login.xml` y del `activity_horizontal_login.xml`
* El uso de la etiqueta `<uses-permission>` para que nuestra aplicación pueda acceder al internet

> Los temas para las ActionBars se encuentran, detallan y/o añaden en themes.xml
```xml
<resources xmlns:tools="http://schemas.android.com/tools">
    <!-- Base application theme. -->
    <style name="Base.Theme.NICESTART" parent="Theme.Material3.DayNight.NoActionBar">
        <!-- Customize your light theme here. -->
        <!-- <item name="colorPrimary">@color/my_light_primary</item> -->
        <item name="android:windowIsTranslucent">true</item>
    </style>

    <style name="Theme.NICESTART" parent="Base.Theme.NICESTART"/>
    <style name="Theme.NICESTART.ActionBar" parent="Theme.Material3.DayNight"/>
</resources>
```

Una vez realizada la interactividad con ActionBar, se debe implementar código Java para las interacciones que requieren pulsar un botón.
Para ello se debe utilizar un objeto de la clase Intent y englobar la acción en un método:

```java
public void openMain(View v) {
        Intent intent = new Intent(Login.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);

    }

public void openSignup (View v) {
        Intent intent = new Intent(Login.this, Signup.class);
        startActivity(intent);
    }
```

> Debe existir la propiedad onclick (o cualquier otra que se busca) igualada al nombre del método previamente en el xml de la actividad. 
> El ejemplo está tomado del `Login.java`

```xml
<Button
        android:id="@+id/register"
        android:text="@string/register"
        android:onClick="openSignup"
        app:cornerRadius="8dp"
        app:layout_constraintEnd_toEndOf="@id/guide2"
        app:layout_constraintStart_toStartOf="@id/guide1"
        app:layout_constraintTop_toBottomOf="@id/login"
        style="@style/buttonOutlined" />
```

Animaciones Sencillas 
---------------------
Con el objetivo de añadir fluidez a la aplicación, se ha explorado añadir animaciones mediante el propio Android Studio. Para ello,
se pueden crear ficheros XML en la carpeta anim:

![image](https://github.com/user-attachments/assets/2503c727-09c7-4789-aace-5c2a3d0e6dec)

Una vez visualizadas las animaciones, para traducirlo en código se puede realizar lo siguiente:

```xml
<?xml version="1.0" encoding="utf-8"?>
<set xmlns:android="http://schemas.android.com/apk/res/android"
    android:fillAfter="true">
    <scale
        android:duration="2000"
        android:pivotY="50%"
        android:pivotX="50%"
        android:fromXScale="0"
        android:fromYScale="0"
        android:toXScale="1.55"
        android:toYScale="1.55"
        />

    <translate
        android:duration="2000"
        android:fromYDelta="0"
        android:toYDelta="-50%"
        />

    <alpha
    android:duration="350"
    android:fromAlpha="0.0"
    android:repeatCount="8"
    android:repeatMode="reverse"
    android:toAlpha="1.0"
        />
</set>
```

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

Una vez hechas las animaciones, para implementarlas se debe utilizar AnimationUtils de la siguiente forma:

```java
ImageView logo = (ImageView) findViewById(R.id.logo);
TextView appName = (TextView) findViewById(R.id.appName);
TextView welcomeMssg = (TextView) findViewById(R.id.welcome);

Animation newAnimBlink = AnimationUtils.loadAnimation(this,R.anim.blink);
logo.startAnimation(newAnimBlink);

Animation newAnimRotate = AnimationUtils.loadAnimation(this,R.anim.rotate);
appName.startAnimation(newAnimRotate);

Animation newAnimZoom = AnimationUtils.loadAnimation(this,R.anim.zoom_in_out);
welcomeMssg.startAnimation(newAnimZoom);

```
BottomNavigationBar
---------------------------------
En muchas aplicaciones se puede observar una barra de navegación en la parte inferior de la pantalla que facilita el uso y acceso a distintas partes
de dichas aplicaciones, lo cual le otorga al usuario una sensación de comodidad. Para implementarlo, se han de utilizar menús, fragmentos y actividades
