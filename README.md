# CustomString

```
This plugin adds few custom methods to String class:

    1. trunc() to truncate a string to some length.
    2. ellipsis() to add "..." after the truncation.
    3. clean() to clean the string content. It normalize all special characters and remove non-text inputs.
```

## Installation

Download and extract the zip. Go to the root of the plugin, and run grails maven-install (from release plugin) which would build the plugin artifact for you in you local maven repository if you have one setup.
Now just add the following in your BuildConfig.groovy

```
plugins{
    ...
    runtime ":custom-string:0.1"
    ...
}
```

##Usage:

1) trunc(int sizeOfString)
```
"This is a custom method to truncate the string to given size".trunc(20)
//Output: This is a custom met
```

2) ellipsis(int sizeOfString)
```
"This is a custom method to truncate the string to given size".ellipsis(23)
//Output: This is a custom met...
```

3) clean(): This methods is very helpful when user copy/paste text from MS word/excel or some other editor which can have non text inputs.
```
String input = "Tĥïŝ ĩš â fůňķŷ Šťŕĭńġ.";
input += "•\tIt will remove all the non text inputs.•\tIt will fill spaces with non text inputs o\t. o\t".clean()
//Output: This is a funky String. It will remove all the non text inputs. It will fill spaces with non text inputs .
```

All the above methods can be used on String variables and on GStrings.