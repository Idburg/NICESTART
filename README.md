PROYECTO NICESTART
==================
El objetivo de este proyecto fue realizar el boceto de una aplicacion de registro básica para aprender
a utilizar Android Studio, particularmente la implementación de layouts y la conectividad entre sí. En este proyecto se 
ha utilizado el ConstraintLayout englobando todos los objetos para ajustar a medida las dimensiones de éstos.

Activity Login
--------------
El diseño de esta actividad está realizado con componentes del Material Design proporiconados por defecto por
Android Studio. Se han realizado dos activites distintas teniendo en cuenta la orientación del dispositivo:

![image](https://github.com/user-attachments/assets/463fb2fb-6265-4dc5-9452-3aae3d595746)

![image](https://github.com/user-attachments/assets/fb6a7d9e-2738-4934-9cdb-6bf53276470d)

Se puede apreciar que los colores están personalizados y el fondo de pantalla es un gradiente creado a partir de 
ellos. Esto se puede realizar creando ficheros xml en la carpeta @drawable; en este caso siendo colors.xml y gradient.xml:

![image](https://github.com/user-attachments/assets/1e6137dc-d024-47e0-a31e-243700c24324)

![image](https://github.com/user-attachments/assets/a4ccd8fb-fed3-44c4-a871-85793b8804d8)

En cuanto a los botones, se ha creado un fichero styles.xml en donde se han realizado las siguientes especificaciones:

![image](https://github.com/user-attachments/assets/dc97ec8e-1d28-467d-bfae-f47467ae3cf2)

Activity Signup
---------------
El diseño de esta actividad es muy parecido al del activity login pero aquí se pueden apreciar más campos para la
entrada de texto.

![image](https://github.com/user-attachments/assets/2f745b02-ea77-425d-9671-ec005648d774)

Se puede apreciar en ambas actividades la aparición de iconos a la izquierda del texto, lo cual se puede implementar
con la propiedad app:startIconDrawable.

![image](https://github.com/user-attachments/assets/efeafa3a-c69d-48ab-bfe8-8b1bcb5ec1ef)


Activity Profile
----------------
Esta actividad es un boceto de una ventana de Profile donde el usuario consultará sus datos personales.
Es un diseño muy sencillo y existe para probar el uso de la librería Glide para darle estilo a la imagen del avatar.

![image](https://github.com/user-attachments/assets/47c99314-35ae-42e4-bbb7-04fad33daad9)

La funcionalidad del Glide se debe realizar en el archivo Java asociado con la actividad y,
en este caso, tendrá el siguiente código adicional al ya generado:

![image](https://github.com/user-attachments/assets/a2d42d87-c64d-4bc0-b85b-e2d30197e03c)

> Para utilizar Glide, se deben importan en build.gradle.kts(:app)

> ![image](https://github.com/user-attachments/assets/9aedce3d-8115-48ee-bd25-9e304dafba59)


Activity Splash
---------------
Esta actividad es la pantalla de carga de la aplicación y sirve como un "testing ground" para el uso de animaciones, que se detallará más después.

![image](https://github.com/user-attachments/assets/71bea20d-6f31-452b-af16-b4148fd8390f)


Activity Main
-------------
Esta actividad, por muy simple que parezca tiene muchísimos componentes dinámicos, tanto para la imagen de la web como para la ActionBar

![image](https://github.com/user-attachments/assets/cbf94cb0-abfb-4049-a1ce-f0a69c282f12)

Para empezar, la imagen proviene de una pagina web que por cada vez que se refresca se cambia, por lo cual en el .xml se debe contener
en 

![image](https://github.com/user-attachments/assets/9a272844-61d3-4d54-9f38-464827a4c513)

![image](https://github.com/user-attachments/assets/e872185c-6637-42d2-bf34-796040f3dfcb)


Interactividad
--------------
Dado que se buscaba añadir interactividad entre las actividades, lo primero que se hizo fue especificar qué botón lleva a qué sitio y
qué actividad lleva ActionBar y no. Para ello, se debe configurar el AndroidManifest de la siguiente forma:

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


Animaciones
------------
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

