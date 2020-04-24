# Mill source bug reproduction

This is a reproduction of a bug that occurs when watching a `T.source` task.

I expect the downstream target to update when the contents of the upstream `T.source` are modified.

This project contains two targets:

 - `first` is the upstream source.  It points to the `first.txt` file.  It should be re-calculated whenever `first.txt` is modified.
 - `second` is a downstream target.  It should also be re-run whenever `first.txt` is modified.

## Steps to reproduce

1 . Run

```
$ mill -w myModule.second
[2/2] myModule.second
The first.txt file was modified
Watching for changes to 0 dirs and 2 files... (Ctrl-C to exit)
```

2. Modify the `first.txt` file

## Observed behaviour

 - The contents of `out/myModule/first/meta.json` are not modified
 - The text `The first.txt file was modified` is not printed.

## Expected behaviour

 - The contents of `out/myModule/first/meta.json` should be modified
 - The text `The first.txt file was modified` should be printed.
