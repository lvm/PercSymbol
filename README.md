# PercSymbol

A class that returns associated MIDI notes according to General MIDI Level 2.  
Note:  
This supersedes this Pattern Class [Pgmdrum](https://github.com/lvm/Pgmdrum) which I'll leave just because it might be useful sometime. 


## Installation

Simply clone this repository in the `Extension` directory.  
The path can be found by evaluating `Platform.userExtensionDir` or `Platform.systemExtensionDir`.

## Usage

```
(
x = Pseq(['bd', \sn, \ch].gmPerc, inf).asStream;
10.do{ x.next.postln };
)
36
38
42
36
38
42
36
38
42
36
-> 10
```

```
PercSymbol(\sn);
-> 38

PercSymbol([\sn, \bd, \r]);
-> [ 38, 36, rest ]

PercSymbol([\sn, \bd, [\r, \sn, \ch]]);
-> [ 38, 36, [ rest, 38, 42 ] ]
```

```
['bd', \sn, \ch, \rest].gmPerc
-> [ 36, 38, 42, rest ]
```

## Reference

* https://www.midi.org/specifications/item/gm-level-1-sound-set
* https://en.wikipedia.org/wiki/General_MIDI_Level_2#Drum_sounds

## License

[LICENSE](LICENSE)
