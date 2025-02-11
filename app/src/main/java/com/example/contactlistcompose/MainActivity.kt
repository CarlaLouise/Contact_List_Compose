package com.example.contactlistcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.contactlistcompose.ui.theme.ContactListComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ContactListComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val angelica = Contato(
                        name = "Angelica",
                        telephony = "(+55) 11 953495674",
                        image = R.drawable.angelica
                    )

                    val antony = Contato(
                        name = "Antony",
                        telephony = "(+55) 21 946783409",
                        image = R.drawable.antony
                    )

                    val bruna = Contato(
                        name = "Bruna",
                        telephony = "(+55) 85 946783409",
                        image = R.drawable.bruna
                    )

                    val eduardo = Contato(
                        name = "Eduardo",
                        telephony = "(+55) 85 947783539",
                        image = R.drawable.eduardo
                    )


                    val fernanda = Contato(
                        name = "Fernanda",
                        telephony = "(+55) 87 927672481",
                        image = R.drawable.fernanda
                    )

                    val iury = Contato(
                        name = "Iury",
                        telephony = "(+55) 21 967452217",
                        image = R.drawable.iury
                    )

                    val katia = Contato(
                        name = "Katia",
                        telephony = "(+55) 82 945401489",
                        image = R.drawable.katia
                    )

                    val leila = Contato(
                        name = "Leila",
                        telephony = "(+55) 81 933365137",
                        image = R.drawable.leila
                    )

                    val lucas = Contato(
                        name = "Lucas",
                        telephony = "(+55) 81 951375137",
                        image = R.drawable.lucas
                    )

                    val maria = Contato(
                        name = "Maria",
                        telephony = "(+55) 21 983267145",
                        image = R.drawable.maria
                    )

                    val nisan = Contato(
                        name = "Nisan",
                        telephony = "(+55) 11 924568129",
                        image = R.drawable.nisan
                    )

                    val olivia = Contato(
                        name = "Olivia",
                        telephony = "(+55) 21 952196520",
                        image = R.drawable.olivia
                    )

                    val patricia = Contato(
                        name = "Patricia",
                        telephony = "(+55) 71 942136702",
                        image = R.drawable.patricia
                    )

                    val samara = Contato(
                        name = "Samara",
                        telephony = "(+55) 84 984287204",
                        image = R.drawable.samara
                    )

                    val silvio = Contato(
                        name = "Silvio",
                        telephony = "(+55) 87 937778899",
                        image = R.drawable.silvio
                    )

                    val vicente = Contato(
                        name = "Vicente",
                        telephony = "(+55) 81 987329974",
                        image = R.drawable.vicente
                    )

                    val contato = listOf(
                        angelica, antony, bruna, eduardo, fernanda,
                        iury, katia, leila, lucas, maria, nisan,
                        olivia, patricia, samara, silvio, vicente
                    )

                    LazyColumn {
                        items(contato) { contato ->
                            Contactcard(
                                contact = contato,
                                onClick = {
                                    println("test" + contato.name)
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Contactcard(
    contact: Contato,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .clickable(onClick = onClick)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.FillWidth,
                painter = painterResource(id = contact.image),
                contentDescription = "Contact image"
            )
            Spacer(modifier = Modifier.size(16.dp))
            Column {
                Text(
                    text = contact.name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = contact.telephony,
                    color = Color.Gray
                )
            }
        }
    }
}

data class Contato(
    val name: String,
    val telephony: String,
    @DrawableRes val image: Int

)

@Preview(showBackground = true)
@Composable
fun ContactCardPreview() {
    ContactListComposeTheme {
        val contato = Contato(
            name = "Angelica",
            telephony = "(55) 11 953495674",
            image = R.drawable.angelica
        )
        Contactcard(
            contact = contato,
            onClick = {
            }
        )
    }
}