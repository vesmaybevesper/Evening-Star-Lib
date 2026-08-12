- Backport recent additions to 1.21.11 & 1.21.1
- Add Support for 1.20.1 (Fabric & Forge)
- Add `isSodiumLike()`
  - Checks for Sodium, Embeddium, or Rubidium, may be useful for legacy modding
- Add `sodiumLikeType()`
  - Returns a string with which mod is present, for when the differences matter :)
  - Runs `isSodiumLike()`
- Mark `isSodium()` as deprecated, will eventually be removed in favor of `isSodiumLike()`
- Update FastJSON to 2.0.64

Alpha Fixes:
- Actually bumped the version this time
  - This should fix mods not recognizing this as a valid version if they have a >= for the version range
- Fix a couple of imports not being versioned correctly
- Fix an event class not recognizing an extension
- Fix a Mixin Local being wrong on some versions
- Delete some wip code that was refusing to stay commented out through version switches
