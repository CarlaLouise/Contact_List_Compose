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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

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

                    val contato = listOf(
                        Contato("Angelica","(+55) 11 953495674", R.drawable.angelica),
                        Contato("Antony","(+55) 21 946783409", R.drawable.antony),
                        Contato("Bruna","(+55) 85 946783409", R.drawable.bruna),
                        Contato("Eduardo","(+55) 85 947783539", R.drawable.eduardo),
                        Contato("Fernanda","(+55) 87 927672481", R.drawable.fernanda),
                        Contato("Iury","(+55) 21 967452217", R.drawable.iury),
                        Contato("Katia","(+55) 82 945401489", R.drawable.katia),
                        Contato("Leila","(+55) 81 933365137", R.drawable.leila),
                        Contato("Lucas","(+55) 81 951375137", R.drawable.lucas),
                        Contato("Maria","(+55) 21 983267145", R.drawable.maria),
                        Contato("Nisan","(+55) 11 924568129", R.drawable.nisan),
                        Contato("Olivia","(+55) 21 952196520", R.drawable.olivia),
                        Contato( "Patricia","(+55) 71 942136702", R.drawable.patricia),
                        Contato("Samara","(+55) 84 984287204", R.drawable.samara),
                        Contato("Silvio","(+55) 87 937778899", R.drawable.silvio),
                        Contato("Vicente","(+55) 81 987329974", R.drawable.vicente)
                    )

                    ContactListWithHeader(contato)

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

@Composable
fun ContactListWithHeader(contato: List<Contato>) {
    var isGrid by remember { mutableStateOf(false) }

    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = "Contact List",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1f)
            )
            IconButton(onClick = { isGrid = !isGrid}) {
                Icon(painter = painterResource(if (isGrid)R.drawable.ic_list else R.drawable.ic_grid),
                    contentDescription = "Alternar Exibição"
                )
            }
        }
        if (isGrid){
            LazyVerticalGrid(columns = GridCells.Fixed(2), modifier = Modifier.padding(8.dp)) {
                items(contato.size) { index: Int ->
                    Contactcard(contact = contato[index],
                        onClick = { println("Clicked: ${contato[index].name} ") }
                    )
                }
            }
        }else{
            LazyColumn {
                items(contato){ contato ->
                    Contactcard(
                        contact = contato,
                        onClick = { println("Clicked: ${contato.name}") }
                    )
                }
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