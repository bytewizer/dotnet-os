inherit extrausers

DOTNET_USER_ID ?= "1000"
DOTNET_USER_GROUP ?= "users"
DOTNET_USER_NAME ??= "roslyn"
DOTNET_USER_PASSWORD ??= "dotnet"
DOTNET_USER_PASSWORD_ENCRYPTED ??= "$(openssl passwd -5 ${DOTNET_USER_PASSWORD})"

ROOT_PASSWORD ??= "root"
ROOT_PASSWORD_ENCRYPTED ??= "$(openssl passwd -5 ${ROOT_PASSWORD})"

DOTNET_USER_HOMEDIR ?= "/home/${DOTNET_USER_NAME}"

DOTNETUSERADD_COMMAND ?= "\
  --create-home \
  --groups ${DOTNET_USER_GROUP}\
  --uid ${DOTNET_USER_ID} \
  --home ${DOTNET_USER_HOMEDIR} \
  ${DOTNET_USER_NAME} \
"

EXTRA_USERS_PARAMS = "\
    groupadd ${DOTNET_USER_GROUP}; \
	useradd  ${DOTNETUSERADD_COMMAND}; \
    usermod -p '${DOTNET_USER_PASSWORD_ENCRYPTED}' ${DOTNET_USER_NAME}; \
    ${@bb.utils.contains('DISABLE_ROOT', '0', "usermod -L root;", "usermod -p '${ROOT_PASSWORD_ENCRYPTED}' root;", d)} \
"