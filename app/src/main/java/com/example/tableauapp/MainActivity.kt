package com.example.tableauapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tableauapp.ui.theme.TableauAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TableauAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Tableau(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Tableau(modifier: Modifier = Modifier) {
    var tableauNbr by remember {
        mutableIntStateOf(1)
    }

    when (tableauNbr) {
        1 -> TableauTextAndImage(
            R.drawable.photo1,
            R.string.titre1,
            R.string.desc1,
            R.string.auteur1,
            R.string.année1,
            { tableauNbr = 1 },
            { tableauNbr++ }
        )

        2 -> TableauTextAndImage(
            R.drawable.photo2,
            R.string.titre2,
            R.string.desc2,
            R.string.auteur2,
            R.string.année2,
            { if (tableauNbr != 1) tableauNbr-- },
            { tableauNbr++ }
        )

        3 -> TableauTextAndImage(
            R.drawable.photo3,
            R.string.titre3,
            R.string.desc3,
            R.string.auteur3,
            R.string.année3,
            { if (tableauNbr != 1) tableauNbr-- },
            { tableauNbr++ }
        )

        4 -> TableauTextAndImage(
            R.drawable.photo4,
            R.string.titre4,
            R.string.desc4,
            R.string.auteur4,
            R.string.année4,
            { if (tableauNbr != 1) tableauNbr-- },
            { tableauNbr = 1 }
        )

        5 -> TableauTextAndImage(
            R.drawable.photo5,
            R.string.titre5,
            R.string.desc5,
            R.string.auteur5,
            R.string.année5,
            { if (tableauNbr != 1) tableauNbr-- },
            { tableauNbr++ }
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TableauPreview() {
    var tableauNbr by remember {
        mutableIntStateOf(1)
    }

    when (tableauNbr) {
        1 -> TableauTextAndImage(
            R.drawable.photo1,
            R.string.titre1,
            R.string.desc1,
            R.string.auteur1,
            R.string.année1,
            { tableauNbr = 1 },
            { tableauNbr++ }
        )

        2 -> TableauTextAndImage(
            R.drawable.photo2,
            R.string.titre2,
            R.string.desc2,
            R.string.auteur2,
            R.string.année2,
            { if (tableauNbr != 1) tableauNbr-- },
            { tableauNbr++ }
        )

        3 -> TableauTextAndImage(
            R.drawable.photo3,
            R.string.titre3,
            R.string.desc3,
            R.string.auteur3,
            R.string.année3,
            { if (tableauNbr != 1) tableauNbr-- },
            { tableauNbr++ }
        )

        4 -> TableauTextAndImage(
            R.drawable.photo4,
            R.string.titre4,
            R.string.desc4,
            R.string.auteur4,
            R.string.année4,
            { if (tableauNbr != 1) tableauNbr-- },
            { tableauNbr = 1 }
        )

        5 -> TableauTextAndImage(
            R.drawable.photo5,
            R.string.titre5,
            R.string.desc5,
            R.string.auteur5,
            R.string.année5,
            { if (tableauNbr != 1) tableauNbr-- },
            { tableauNbr++ }
        )
    }
}

@Composable
fun TableauTextAndImage(
    imageId: Int,
    imageStringDescription: Int,
    artTitleId: Int,
    autorId: Int,
    yearId: Int,
    previous: () -> Unit,
    next: () -> Unit,
    modifier: Modifier = Modifier
) {
    val image = painterResource(id = imageId)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .padding(20.dp)
            .fillMaxSize()
            .statusBarsPadding()
            .verticalScroll(rememberScrollState())
            .safeDrawingPadding(),
    ) {
        Column(
            modifier = modifier
                .shadow(
                    elevation = 16.dp,
                    ambientColor = Color.Gray,
                    spotColor = Color.Black
                )
                .border(
                    border = BorderStroke(
                        40.dp,
                        Color.White,
                    ),
                )
        ) {
            Image(
                painter = image,
                contentDescription = stringResource(imageStringDescription),
                modifier = Modifier.size(400.dp, 400.dp),
                contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier = Modifier.height(50.dp))
        Column(
            modifier = Modifier
                .background(Color(0xFFECEBF0))
                .padding(20.dp)
        ) {
            Column {
                Text(
                    text = stringResource(artTitleId),
                    fontWeight = FontWeight.Light,
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.height(5.dp))
                Row {
                    Text(
                        text = stringResource(autorId),
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = stringResource(yearId),
                        fontWeight = FontWeight.Light
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(50.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Button(
                onClick = previous,
                modifier = Modifier
                    .width(150.dp)
            ) {
                Text(text = "Previous")
            }
            Button(
                onClick = next,
                modifier = Modifier
                    .width(150.dp)
            ) {
                Text(text = "Next")
            }
        }
    }
}