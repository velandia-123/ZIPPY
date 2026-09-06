package components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ui.*

@Composable
fun ZippyButton(

    text: String,

    onClick: () -> Unit

) {

    Button(

        onClick = onClick,

        modifier = Modifier
            .fillMaxWidth()
            .height(58.dp),

        shape = ZippyShapes.Medium,

        colors = ButtonDefaults.buttonColors(
            containerColor = ZippyBlue
        )

    ) {

        Text(

            text = text,

            style = ZippyTypography.Button

        )

    }

}