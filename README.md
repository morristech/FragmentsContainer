# FragmentsContainer
This project is intends create an activity that loads any fragment of projects with some prerequisites like bundle, title etc


Sample usage 
----------------------
```
              Bundle bundle = new Bundle();
              bundle.putParcelable("key_bundle", getModel());
              bundle.putString("key_name", "ManojBhadane");

                new ContainerModel()
                        .setTitle("Fragment 1")
                        .setFragmentNumber(Constant.FRAGMENT_1)
                        .setBundle(bundle)
                        .setShowToolbar(false)
                        .setShowToolbarBackBtn(false)
                        .startActivity(MainActivity.this);
                        
 ```
 
 Only setFragmentNumber() is mandatory method, rest all are optionals
                        
                        


![alt text](https://github.com/manojbhadane/FragmentsContainer/blob/master/desk1.png)
