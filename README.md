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

Activity Signup
---------------
El diseño de esta actividad es muy parecido al del activity login pero aquí se pueden apreciar más campos para la
entrada de texto.

![image](https://github.com/user-attachments/assets/2f745b02-ea77-425d-9671-ec005648d774)

Se puede apreciar en ambas actividades la aparición de iconos a la izquierda del texto, lo cual se puede implementar
con la propiedad app:startIconDrawable.

![image](https://github.com/user-attachments/assets/efeafa3a-c69d-48ab-bfe8-8b1bcb5ec1ef)


Activity Profile/Main
----------------
Esta actividad no es más que un boceto para refactorizarlo en una nueva actividad Profile pero que actualmente ocupa el Main.
Es un diseño muy sencillo y existe para probar el uso de la librería Glide para darle estilo a la imagen del avatar.

![image](https://github.com/user-attachments/assets/47c99314-35ae-42e4-bbb7-04fad33daad9)

La funcionalidad del Glide se debe realizar en el archivo Java asociado con la actividad y,
en este caso, tendrá el siguiente código adicional al ya generado:

![image](https://github.com/user-attachments/assets/a2d42d87-c64d-4bc0-b85b-e2d30197e03c)

Interactividad
-------------

![image](https://github.com/user-attachments/assets/95f3fbff-2fa9-4cfd-8b60-613e77d27f0b)
![image](https://github.com/user-attachments/assets/eb309bfa-b0cc-49c6-9d87-4dd6a72d0bf1)
![image](https://github.com/user-attachments/assets/dc97ec8e-1d28-467d-bfae-f47467ae3cf2)



