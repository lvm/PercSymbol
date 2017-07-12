/*
        PercSymbol class
        .gmPerc method
        .asGMPerc method

        (c) 2017 by Mauro <mauro@sdf.org>
        http://cyberpunk.com.ar/

        A class that returns associated MIDI notes according to General MIDI Level 2.
        Reference:
        * https://www.midi.org/specifications/item/gm-level-1-sound-set
        * https://en.wikipedia.org/wiki/General_MIDI_Level_2#Drum_sounds

*/

VoxSymbol {

  classvar <midiNotes;

  *new {
    |input|
    ^this.asVox(input);
  }

  *initClass {
    midiNotes = (
      \inhale: 60, // hi bongo
      \wah: 61, // low bongo
      \uh: 62, // mute hi conga
      \oh: 63, // open hi conga
      \pow: 64, // low conga
      \but: 65, // hi timbale
      \ahw: 66, // low timbale
      \ahm: 67, // high agogo
      \whi: 68, // low agogo
      \exhale: 69, // cabasa
      \pho: 70, // maracas
      \mmm: 71, // short whistle
      \ah: 72, // long whistle
    );
  }

  *notes {
    ^midiNotes.keys;
  }

  *asVox {
    |input|

    // return...

    // rercusive funkyness
    if(input.isKindOf(Array) or: (input.isKindOf(List))) {
      ^input.collect({ |i| this.asVox(i) });
    };

    // or the note
    if(midiNotes[input.asSymbol].isNil.not) {
      ^midiNotes[input.asSymbol];
    };

    // or a \rest
    if(input.isRest) {
      ^\rest;
    };

    // or whatever it was received
    ^input;
  }

}


+ SequenceableCollection {

  asVox {
    ^VoxSymbol.asVox(this);
  }

}
