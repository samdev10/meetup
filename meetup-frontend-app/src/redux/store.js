import { combineReducers, createStore } from 'redux'
import authReducer from './authSlice.js'
import groupReducer from './groupSlice.js'
import eventReducer from './eventSlice.js'
import sessionReducer from './sessionSlice.js'
import { reducer as formReducer } from 'redux-form'
import { persistStore, persistReducer } from 'redux-persist'
import storage from 'redux-persist/lib/storage' // defaults to localStorage for web

const persistConfig = { key: 'root', storage}

const reducer = {
  auth: authReducer,
  group: groupReducer,
  event: eventReducer,
  session: sessionReducer,
  form: formReducer.plugin({
    group: (state, action) => {
      switch (action.type) {
        case "GROUP_SAVE_SUCCESS":
          return undefined // <--- blow away form data
          default:
            return state
          }
        }
      },
      {
        event: (state, action) => {
          switch (action.type) {
            case "EVENT_SAVE_SUCCESS":
              return undefined // <--- blow away form data
              default:
                return state
              }
            }
          })
    };

    export const rootReducer = combineReducers(reducer)
    const persistedReducer = persistReducer(persistConfig, rootReducer);

    export let store = createStore(persistedReducer);
    export let persistor = persistStore(store)