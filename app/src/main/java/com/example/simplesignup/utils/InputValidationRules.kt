package com.example.simplesignup

fun validateFirstName(firstName: CharSequence): Boolean {
    return Regex(REGEXFIRSTNAME).containsMatchIn(firstName)
}

fun validateEmailAddress(emailAddress: CharSequence): Boolean {
    return Regex(REGEXEMAIL).containsMatchIn(emailAddress)
}

fun validateWebUrl(emailAddress: CharSequence): Boolean {
    return return Regex(REGEXWEBURLSTARTWITHHTTPORHTTPS).containsMatchIn(emailAddress)
}


const val REGEXWEBURLSTARTWITHHTTPORHTTPS = "^((https?|ftp|smtp):\\/\\/)?(www.)?[a-z0-9]+\\.[a-z]+(\\/[a-zA-Z0-9#]+\\/?)*\$"
const val REGEXEMAIL = "^\\S+@\\S+\$"
const val REGEXFIRSTNAME = "^[A-Za-z]+(((\\'|\\-|\\.)?([A-Za-z])+))?\$"