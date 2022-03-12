package emlakburada.service;

import org.springframework.stereotype.Service;

import emlakburada.dto.AuthRequest;
import emlakburada.dto.AuthResponse;
import emlakburada.entity.User;
import emlakburada.exception.UserNotFoundException;
import emlakburada.exception.UserPasswordNotValidException;
import emlakburada.repository.AuthRepository;
import emlakburada.util.JwtUtil;
import emlakburada.util.UserUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class AuthService {

	private final AuthRepository authRepository;

	private final JwtUtil jwtUtil;

	public AuthResponse getToken(AuthRequest request) throws UserPasswordNotValidException {
		User user = authRepository.findByEmail(request.getEmail())
				.orElseThrow(() -> new UserNotFoundException("User not found"));


		if (!UserUtil.isValidPassword(user.getPassword(), request.getPassword())) {
			log.error("User's password not valid " + request.getEmail());
			throw new UserPasswordNotValidException("User's password not valid");
		}

		return new AuthResponse(jwtUtil.generateToken(user));
	}

}
