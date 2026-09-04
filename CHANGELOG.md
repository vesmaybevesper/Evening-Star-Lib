## Release Highlight

- Renamed and relocated all utility packages, now located at `dev.vesper.eveningstarlib.common.utilities`
  - `ESLModChecks` -> `ModChecks`
  - `ESLPosUtils` -> `PosUtils`
  - `ESLRenderUtils` -> `RenderUtils`
- Relocated the default FastJson2 config serializer to `dev.vesper.eveningstarlib.common.serializers.fastjson.JSON`
- Performance optimizations to the default FastJson2 config serializer [WIP]
- Added support for JsonB with FastJson2 [WIP]
  - `dev.vesper.eveningstarlib.common.serializers.fastjson.JSONB`
- Added a YACL Config serializer using WAST [WIP]
  - `dev.vesper.eveningstarlib.common.serializers.wast`
- Add (and improve exiting) documentation
